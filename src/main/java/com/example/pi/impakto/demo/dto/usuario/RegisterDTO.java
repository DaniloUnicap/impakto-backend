package com.example.pi.impakto.demo.dto.usuario;

import com.example.pi.impakto.demo.model.Enum.UserRole;

public record RegisterDTO(String nomeUsuario, String senha, UserRole role) {} 