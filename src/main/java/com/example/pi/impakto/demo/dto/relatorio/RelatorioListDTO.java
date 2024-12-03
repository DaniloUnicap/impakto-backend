package com.example.pi.impakto.demo.dto.relatorio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelatorioListDTO {

  private Long id;
  private String tituloRelatorio;
  private Long outdoorId;
  private Long clienteId;
}
