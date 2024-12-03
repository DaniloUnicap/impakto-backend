package com.example.pi.impakto.demo.dto.contrato;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContratoUpdateDTO {
    
    private Long idCliente;
    private Long idOutdoor;
    private LocalDate data;
    private String assinaturaDigital;
    private LocalDate prazo;
}
