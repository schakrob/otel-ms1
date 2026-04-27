package com.example.service;

import com.example.dto.RequestDto;
import com.example.dto.ResponseDto;
import io.micrometer.observation.annotation.Observed;
import io.opentelemetry.api.trace.Span;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class Step2 {

    private final WebClient webclient;

    @Observed(name = "ms1.step2", contextualName = "execute-step2")
    public ResponseDto execute(RequestDto request) {
        log.info("Executing Step 2 in MS1 - Calling Microservice2");

        Span span = Span.current();
        span.setAttribute("step", "step2");
        span.setAttribute("targetService", "call-ms2");
        span.addEvent("Executing step2");

        // Create request - NO trace info needed
        RequestDto m2Request = RequestDto.builder()
                .userId(request.getUserId())
                .transactionId(request.getTransactionId())
                .data(request.getData())
                .build();

       try{
           ResponseDto responseDto = webclient.post()
                   .uri("/api/v1/ms2-process")
                   .bodyValue(m2Request)
                   .retrieve()
                   .bodyToMono(ResponseDto.class)
                   .block();

           log.info("Received response from MS3: {}", responseDto);
           return responseDto;
       } catch (Exception e) {
           log.info("Error {}", e.getMessage());
           throw new RuntimeException(e);
       }

    }
}