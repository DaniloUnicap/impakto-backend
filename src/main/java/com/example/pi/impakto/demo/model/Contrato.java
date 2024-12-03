package com.example.pi.impakto.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "cliente_id" 
    )
    @JsonIgnore
    private Cliente cliente;

    @OneToOne
    @JoinColumn(
        name = "outdoor_id"
    )
    @JsonIgnore
    private Outdoor outdoor;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String assinaturaDigital;

    @Column(nullable = false)
    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    @JsonIgnore
    private Relatorio relatorio;

    


}
