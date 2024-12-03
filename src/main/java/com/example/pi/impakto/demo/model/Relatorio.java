package com.example.pi.impakto.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String tituloRelatorio;

  @Column
  private String historico;

  @ManyToOne
  @JoinColumn(name = "outdoor_id")
  @JsonIgnore
  private Outdoor outdoor;

  @OneToOne
  @JoinColumn(name = "cliente_id")
  @JsonIgnore
  private Cliente cliente;

  @OneToMany(mappedBy = "relatorio")
  @JsonIgnore
  private List<Contrato> contratos;

  @OneToMany(mappedBy = "relatorio")
  @JsonIgnore
  private List<Usuario> listaUsuarios;
}
