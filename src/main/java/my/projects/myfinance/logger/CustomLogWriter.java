package my.projects.myfinance.logger;

import my.projects.myfinance.config.WebMvcConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Precorrelation;

import java.io.IOException;

public class CustomLogWriter implements HttpLogWriter {

    private final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public boolean isActive() {
        return this.log.isInfoEnabled();
    }

    @Override
    public void write(Precorrelation precorrelation, String request) throws IOException {
        this.log.info(request);
    }

    @Override
    public void write(Correlation correlation, String response) throws IOException {
        this.log.info(response);
    }
}
