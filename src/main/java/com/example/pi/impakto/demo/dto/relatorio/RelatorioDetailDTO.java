package com.example.pi.impakto.demo.dto.relatorio;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelatorioDetailDTO {

  private Long id;
  private String tituloRelatorio;
  private String historico;
  private Long outdoorId;
  private Long clienteId;
  private List<Long> contratoIds;
}
