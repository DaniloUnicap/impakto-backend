package com.example.pi.impakto.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String local;

    @OneToOne
    @JoinColumn(name = "outdoor_id")
    @JsonIgnore
    private Outdoor outdoor;

    // @OneToOne
    // @JoinColumn(name = "agendamentoLocal_id")
    // @JsonIgnore
    // private Mapa geolocalizacaoAgendado;

    @OneToOne
    @JoinColumn(name = "agendamentoCliente_id")
    @JsonIgnore
    private Cliente cliente;

    private LocalDate data;
    private LocalTime hora;
}