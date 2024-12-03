package com.example.pi.impakto.demo.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Mapa;
import com.example.pi.impakto.demo.model.Outdoor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoListDTO {
    private Long id;
    private String titulo;
    private Outdoor outdoor;
    private Mapa geolocalizacaoAgendado;
    private Cliente cliente;
    private LocalDate data;
    private LocalTime hora;
}
