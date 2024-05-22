package com.codegym.c07blog.payload.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponsePayload {
    private String message;
    private Object data;
    private HttpStatus status;
}
