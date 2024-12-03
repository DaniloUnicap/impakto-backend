package com.example.pi.impakto.demo.dto.cliente;

import java.util.List;

import com.example.pi.impakto.demo.model.Contrato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteListDTO {

    private Long idCliente;
    private List<Contrato> listaContratos; 
    private String nome; 
    private String numeroContato; 
    private String cpfCliente; 
    private String emailCliente; 
    private String cnpjCliente; 

    
}
