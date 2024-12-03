package com.example.pi.impakto.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;


@Entity
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nome; 

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Contrato> listaContratos; 

    @Column
    private String numeroContato; 

    @Column
    private String cpfCliente; 

    @Column
    private String emailCliente; 

    @Column
    private String cnpjCliente; 

    @OneToOne(mappedBy = "cliente")
    @JsonIgnore
    private Agendamento agendamento;

    @OneToOne(mappedBy = "cliente")
    @JsonIgnore
    private Relatorio relatorio;
}
