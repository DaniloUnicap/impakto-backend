package com.example.pi.impakto.demo.dto.cliente;

import java.util.List;

import com.example.pi.impakto.demo.model.Contrato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetClienteDTO {
    
    private List<Contrato> listaContratos; 
    private String nome; 
    private String numeroCliente; 
    private String cpf; 
    private String email; 
    private String cnpj; 
    
}
