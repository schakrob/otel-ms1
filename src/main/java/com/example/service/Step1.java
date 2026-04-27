package com.example.service;


import com.example.dto.RequestDto;
import com.example.dto.ResponseDto;
import io.micrometer.observation.annotation.Observed;
import io.opentelemetry.api.trace.Span;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class Step1 {

    @Observed(name = "ms1.step1", contextualName = "execute-step1")
    public ResponseDto execute(RequestDto request) {
        log.info("Executing Step 1 in MS1");

        Span span = Span.current();
        span.setAttribute("step", "step1");
        span.setAttribute("targetService", "no-service");
        span.addEvent("Executing step1");

        return ResponseDto.builder()
                .status("SUCCESS")
                .message("Step 1 completed")
                .data("Step1 Data: ")
                .build();
    }

}