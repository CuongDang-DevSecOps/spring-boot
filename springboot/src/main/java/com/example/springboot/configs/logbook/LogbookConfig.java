package com.example.springboot.configs.logbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogFormatter;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Sink;

@Configuration
public class LogbookConfig {

    @Bean
    public Sink sink(final HttpLogFormatter formatter,
                     final HttpLogWriter writer) {
        return new CustomSink(formatter, writer);
    }
}
