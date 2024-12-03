package com.example.pi.impakto.demo.exception;

public class UsuarioNotFoundException extends RuntimeException {
 
    public UsuarioNotFoundException(String idUsuario) {
        super("Usuário não encontrado com o ID: " + idUsuario);
    }
}
