package com.example.pi.impakto.demo.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoInsertDTO {
    private String titulo;
    private String local;
    private Long idOutdoor;
    private Long idCliente;
    private LocalDate data;
    private LocalTime hora;
}
