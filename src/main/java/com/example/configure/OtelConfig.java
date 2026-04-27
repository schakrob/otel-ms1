package com.example.configure;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelConfig {

    /*@Bean
    public LoggingSpanExporter loggingSpanExporter(){
      return LoggingSpanExporter.create(true);
    }*/
    /*@Bean
    public SpanExporter loggingSpanExporter(){
        return new JsonLoggingSpanExporter();
    }*/


    //Not required. There is a default SdkTracerProvider LoggingSpanExporter bean get set into ti
    /*@Bean
    public SdkTracerProvider tracerProvider() {
        return SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter.create()))
                .build();
    }*/
}
