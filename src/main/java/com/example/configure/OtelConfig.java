package com.example.configure;

import com.example.exporter.JsonLoggingSpanExporter;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelConfig {

    /*@Bean
    public LoggingSpanExporter loggingSpanExporter(){
      return LoggingSpanExporter.create(true);
    }*/
    @Bean
    public SpanExporter loggingSpanExporter(){
        return new JsonLoggingSpanExporter();
    }


    //Not required. There is a default SdkTracerProvider LoggingSpanExporter bean get set into ti
    /*@Bean
    public SdkTracerProvider tracerProvider() {
        return SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter.create()))
                .build();
    }*/
}
