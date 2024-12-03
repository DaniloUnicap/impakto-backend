package com.example.pi.impakto.demo.exception;

public class ClienteNotFoundException extends RuntimeException {
    
    public ClienteNotFoundException(String message){
        super(message);
    }
}