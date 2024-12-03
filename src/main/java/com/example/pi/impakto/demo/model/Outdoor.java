package com.example.pi.impakto.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Outdoor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String figuraOutdoor;

    @Column
    private String fotoOutdoor;

    @ManyToOne
    @JoinColumn(name = "mapa_id")
    @JsonIgnore
    private Mapa mapa;

    // @Column
    // private String idOutdoor;

    @Column
    private String descricao;

    @Column
    private boolean statusUso;

    @Column
    private String tipoOutdoor;

    @OneToOne(mappedBy = "outdoor")
    @JsonIgnore
    private Agendamento agendamento;

    @OneToOne(
        mappedBy = "outdoor"
    )
    @JsonIgnore
    private Contrato contrato;

    @Embedded
    private Geolocalizacao geolocalizacao;
    
}
