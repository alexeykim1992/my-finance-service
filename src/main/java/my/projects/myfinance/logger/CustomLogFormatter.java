package my.projects.myfinance.logger;

import org.zalando.logbook.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class CustomLogFormatter implements HttpLogFormatter {

    public CustomLogFormatter() {
    }

    @Override
    public String format(Precorrelation precorrelation, HttpRequest request) throws IOException {
        return String.format("Inbound Message\n" +
                        "--------------------------------------\n" +
                        "ID: %s\nAddress: %s\nEncoding: %s\nHttp-Method: %s\n" +
                        "Content-Type: %s\nHeaders: {%s}\nPayload: %s\n" +
                        "--------------------------------------",
                Integer.toUnsignedString(
                        Integer.parseUnsignedInt(
                                precorrelation.getId().substring(0, 8), 16)),
                request.getRequestUri(),
                "UTF-8",
                request.getMethod(),
                request.getContentType(),
                extractHeaders(request.getHeaders()),
                new String(request.getBody(), StandardCharsets.UTF_8));
    }

    @Override
    public String format(Correlation correlation, HttpResponse response) throws IOException {
        return String.format("Outbound Message\n" +
                        "--------------------------------------\n" +
                        "ID: %s\nResponse-Code: %s\nEncoding: %s\nContent-Type: %s\nHeaders: {%s}\nPayload: %s\n" +
                        "--------------------------------------",
                Integer.toUnsignedString(
                        Integer.parseUnsignedInt(
                                correlation.getId().substring(0, 8), 16)),
                response.getStatus(),
                "UTF-8",
                response.getContentType(),
                extractHeaders(response.getHeaders()),
                new String(response.getBody(), StandardCharsets.UTF_8));
    }

    private String extractHeaders(Map<String, List<String>> headers) {
        StringBuilder builder = new StringBuilder();
        for (String key : headers.keySet()) {
            builder.append(", " + key + "=");
            for (String value : headers.get(key)) {
                builder.append("[" + value + "]");
            }
        }
        if (builder.length() >= 2) {
            builder.delete(0, 2);
        }
        return builder.toString();
    }
}
