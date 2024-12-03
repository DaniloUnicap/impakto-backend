package com.example.pi.impakto.demo.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUsuarioDTO {
    
    private String nome; 
    private String resposabilidadeDoDia; 
    private String cargo;  
   
}
