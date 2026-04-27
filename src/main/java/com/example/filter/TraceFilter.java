package com.example.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.LogRecord;

@Slf4j
@Component
public class TraceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                  String traceId = MDC.get("traceId");
                  String spanId = MDC.get("spanId");
                  log.info("traceId "+traceId);
                  log.info("spanId "+spanId);
        filterChain.doFilter(servletRequest, servletResponse);
        // Post-controller
        log.info("Completed request {} {} traceId={} spanId={}",
                traceId, spanId);
    }
}
