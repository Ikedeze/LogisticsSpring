package com.example.logistics.exception;

public class ShipmentAlreadyExistsException extends RuntimeException{
    public ShipmentAlreadyExistsException(String message) {
        super(message);
    }
}
