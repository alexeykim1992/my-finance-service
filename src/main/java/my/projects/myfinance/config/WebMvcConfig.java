package my.projects.myfinance.config;

import my.projects.myfinance.logger.CustomLogFormatter;
import my.projects.myfinance.logger.CustomLogWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.servlet.LogbookFilter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final String appName;
    private final String appDescription;
    private final String appVersion;

    @Autowired
    public WebMvcConfig(@Value("${app.name}") String appName,
                        @Value("${app.description}") String appDescription,
                        @Value("${app.version}") String appVersion) {
        this.appName = appName;
        this.appDescription = appDescription;
        this.appVersion = appVersion;
    }

    Logbook logbook = Logbook.builder()
            .sink(new DefaultSink(
                    new CustomLogFormatter(),
                    new CustomLogWriter())).build();

    @Bean
    public FilterRegistrationBean<LogbookFilter> loggingFilter(){
        FilterRegistrationBean<LogbookFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogbookFilter(logbook));
        registrationBean.addUrlPatterns("/account/*");
        registrationBean.addUrlPatterns("/transaction/*");
        registrationBean.addUrlPatterns("/user/*");
        registrationBean.addUrlPatterns("/icon/*");
        return registrationBean;
    }

    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("my.projects.myfinance"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(appName, appDescription, appVersion, null,
                new Contact("Aleksey Kim (Dev)", "", "alexmail1992@gmail.com"),
                null, null, Collections.emptyList());
    }
}