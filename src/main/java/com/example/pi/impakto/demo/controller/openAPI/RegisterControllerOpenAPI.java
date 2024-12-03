package com.example.pi.impakto.demo.controller.openAPI;

import org.springframework.http.ResponseEntity;
import com.example.pi.impakto.demo.dto.usuario.RegisterDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cadastro")
public interface RegisterControllerOpenAPI {
    @Operation(summary = "Fazer cadastro")
    public ResponseEntity register(RegisterDTO data);
}
