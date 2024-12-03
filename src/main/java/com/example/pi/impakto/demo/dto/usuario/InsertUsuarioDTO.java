package com.example.pi.impakto.demo.dto.usuario;

import com.example.pi.impakto.demo.model.Enum.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class InsertUsuarioDTO {
    
    private String nomeUsuario;
    private String senha;
    private UserRole role;
}
