package com.example.pi.impakto.demo.dto.contrato;

import java.time.LocalDate;

import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Outdoor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContratoListDTO {
    
    private Long id;
    private Cliente cliente;
    private Outdoor outdoor;
    private LocalDate data;
    private String assinaturaDigital;
    private LocalDate prazo;
}
