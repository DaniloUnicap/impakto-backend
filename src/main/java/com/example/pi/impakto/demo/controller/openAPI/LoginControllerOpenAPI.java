package com.example.pi.impakto.demo.controller.openAPI;

import org.springframework.http.ResponseEntity;

import com.example.pi.impakto.demo.dto.usuario.AuthenticationDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Login")
public interface LoginControllerOpenAPI {
    @Operation(summary = "Fazer login")
    public ResponseEntity login(AuthenticationDTO data);
}
