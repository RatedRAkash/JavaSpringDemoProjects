package com.example.demo_akash.exception;


// this we will "Throw" Exception From "Our Code"
public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}