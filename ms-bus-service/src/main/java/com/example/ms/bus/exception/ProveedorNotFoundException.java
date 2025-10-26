package com.example.ms.bus.exception;


public class ProveedorNotFoundException extends RuntimeException {
    public ProveedorNotFoundException(String message) {
        super(message);
    }
}