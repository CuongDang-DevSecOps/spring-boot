package com.example.springboot.configs.logbook;

import io.opentelemetry.api.trace.Span;
import org.zalando.logbook.*;

import java.io.IOException;

public class CustomSink implements Sink {

    private final DefaultSink delegate;

    public CustomSink(HttpLogFormatter formatter,
                      HttpLogWriter writer) {
        this.delegate = new DefaultSink(formatter, writer);
    }

    @Override
    public boolean isActive() {
        return delegate.isActive();
    }

    @Override
    public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
        Span.current()
                .setAttribute("RequestHeaders", request.getHeaders().toString())
                .setAttribute("RequestBody", request.getBodyAsString());
        delegate.write(precorrelation, request);
    }

    @Override
    public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
        Span.current()
                .setAttribute("ResponseHeaders", response.getHeaders().toString())
                .setAttribute("ResponseBody", response.getBodyAsString());
        delegate.write(correlation, request, response);
    }
}