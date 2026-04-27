package com.example.controller;

import com.example.dto.RequestDto;
import com.example.dto.ResponseDto;
import com.example.service.Orchestrator;
import io.opentelemetry.api.trace.Span;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MicroserviceController {

    private final Orchestrator orchestrator;

    @PostMapping("/ms1-process")
    public ResponseDto process(@RequestBody RequestDto request) {
        log.info("Received request in Microservice1: {}", request);
        Span span = Span.current();
        span.setAttribute("endpoint", "/api/v1/ms1-process");
        span.setAttribute("method", "POST");
        span.setAttribute("userId", request.getUserId());

        return orchestrator.orchestrate(request);
    }
}