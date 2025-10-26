package com.example.ms.tracking.exception;


public class ProveedorNotFoundException extends RuntimeException {
    public ProveedorNotFoundException(String message) {
        super(message);
    }
}