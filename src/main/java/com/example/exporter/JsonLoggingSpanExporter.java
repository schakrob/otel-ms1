package com.example.exporter;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.data.SpanData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;

public class JsonLoggingSpanExporter implements SpanExporter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public CompletableResultCode export(Collection<SpanData> spans) {
        spans.forEach(span -> {
            try {
                String json = mapper.writeValueAsString(span);
                System.out.println(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}

