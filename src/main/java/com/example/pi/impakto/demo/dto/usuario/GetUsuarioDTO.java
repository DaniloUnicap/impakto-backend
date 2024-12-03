package com.example.pi.impakto.demo.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GetUsuarioDTO {
    
    private String nomeUsuario;
    private String resposabilidadeDoDia;
    private String cargo;


}
