package com.example.pi.impakto.demo.model;
 
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import lombok.Data;
 
 
@Data
@Entity
public class Mapa {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 
  @Column
  private String geolocalizacao;
 
  @OneToMany(mappedBy = "mapa")
  @JsonIgnore
  private List<Outdoor> outdoor;
 
  // @OneToOne(mappedBy = "geolocalizacaoAgendado")
  // @JsonIgnore
  // private Agendamento localAgendado;
}