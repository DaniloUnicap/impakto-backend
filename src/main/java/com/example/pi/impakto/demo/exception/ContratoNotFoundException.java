package com.example.pi.impakto.demo.exception;

public class ContratoNotFoundException extends RuntimeException{

    public ContratoNotFoundException(String menssagem){
        super(menssagem);
    }
}
