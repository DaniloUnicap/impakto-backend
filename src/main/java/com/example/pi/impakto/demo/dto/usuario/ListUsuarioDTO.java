package com.example.pi.impakto.demo.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ListUsuarioDTO {

    private Long idUsuario;
    private String nome; 
    private String resposabilidadeDoDia; 
    private String cargo; 
   
   }

