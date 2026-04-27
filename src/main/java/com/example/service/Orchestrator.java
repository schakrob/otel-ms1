package com.example.service;

import com.example.dto.RequestDto;
import com.example.dto.ResponseDto;
import io.micrometer.observation.annotation.Observed;
import io.opentelemetry.api.trace.Span;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Orchestrator {

    private final Step1 step1;

    private final Step2 step2;

    public ResponseDto orchestrate(RequestDto request) {
        log.info("Starting orchestration in Microservice1");

        // Step 1: Initial processing with trace and baggage
        ResponseDto step1Response = step1.execute(request);

        // Step 2: Call Microservice2
        ResponseDto step2Response = step2.execute(request);

        return ResponseDto.builder()
                .status("SUCCESS")
                .message("Orchestration completed")
                .data("Step1: " + step1Response.data() + " | Step2: " + step2Response.data())
                .build();
    }

}