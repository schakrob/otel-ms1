package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String userId;
    private String transactionId;
    private String data;
    // REMOVED: traceId and spanId - automatically propagated in headers
}