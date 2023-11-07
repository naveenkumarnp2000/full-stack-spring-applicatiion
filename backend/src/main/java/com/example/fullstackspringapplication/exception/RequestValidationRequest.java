package com.example.fullstackspringapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationRequest extends RuntimeException {

    public RequestValidationRequest(String message) {
        super(message);
    }
}
