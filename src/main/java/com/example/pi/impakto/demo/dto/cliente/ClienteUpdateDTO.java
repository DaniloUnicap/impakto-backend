package com.example.pi.impakto.demo.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteUpdateDTO {

    private String nome; 
    private String numeroCliente; 
    private String cpf; 
    private String email; 
    private String cnpj; 
    
}
