package com.example.springboot.configs.feign;

import feign.Logger;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.okhttp.LogbookInterceptor;

@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public OkHttpClient okHttpClient(Logbook logbook) {
        var client = new okhttp3.OkHttpClient.Builder()
                .addInterceptor(new LogbookInterceptor(logbook))
                .build();
        return new OkHttpClient(client);
    }
}
