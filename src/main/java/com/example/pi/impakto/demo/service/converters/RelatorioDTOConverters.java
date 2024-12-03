package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.relatorio.RelatorioDetailDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioInsertDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioListDTO;
import com.example.pi.impakto.demo.dto.relatorio.RelatorioUpdateDTO;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.model.Relatorio;
import java.util.stream.Collectors;

public class RelatorioDTOConverters {

  // Converte RelatorioInsertDTO para Relatorio (para criação de uma nova entidade)
  public static Relatorio relatorioInsertDTOToModel(RelatorioInsertDTO dto, Cliente cliente, Outdoor outdoor) {
    Relatorio relatorio = new Relatorio();
    relatorio.setTituloRelatorio(dto.getTituloRelatorio());
    relatorio.setHistorico(dto.getHistorico());
    relatorio.setCliente(cliente);
    relatorio.setOutdoor(outdoor);
    // Defina outros relacionamentos (Outdoors, Cliente, etc.) conforme necessário
    return relatorio;
  }

  // Converte Relatorio para RelatorioDetailDTO (para retorno detalhado)
  public static RelatorioDetailDTO toRelatorioDetailDTO(Relatorio relatorio) {
    RelatorioDetailDTO dto = new RelatorioDetailDTO();
    dto.setId(relatorio.getId());
    dto.setTituloRelatorio(relatorio.getTituloRelatorio());
    dto.setHistorico(relatorio.getHistorico());
    dto.setOutdoorId(
      relatorio.getOutdoor() != null ? relatorio.getOutdoor().getId() : null
    );
    dto.setClienteId(
      relatorio.getCliente() != null
        ? relatorio.getCliente().getIdCliente()
        : null
    );
    dto.setContratoIds(
      relatorio.getContratos() != null
        ? relatorio
          .getContratos()
          .stream()
          .map(contrato -> contrato.getId())
          .collect(Collectors.toList())
        : null
    );
    // Mapear listaUsuarios caso necessário
    return dto;
  }

  // Converte Relatorio para RelatorioListDTO (para listagens simplificadas)
  public static RelatorioListDTO toRelatorioListDTO(Relatorio relatorio) {
    RelatorioListDTO dto = new RelatorioListDTO();
    dto.setId(relatorio.getId());
    dto.setTituloRelatorio(relatorio.getTituloRelatorio());
    dto.setOutdoorId(
      relatorio.getOutdoor() != null ? relatorio.getOutdoor().getId() : null
    );
    dto.setClienteId(
      relatorio.getCliente() != null
        ? relatorio.getCliente().getIdCliente()
        : null
    );
    return dto;
  }

  // Atualiza a entidade Relatorio com os valores de RelatorioUpdateDTO
  public static void relatorioUpdateDTOToModel(
    RelatorioUpdateDTO dto, Relatorio relatorio, Cliente cliente, Outdoor outdoor
  ) {
    relatorio.setTituloRelatorio(dto.getTituloRelatorio());
    relatorio.setHistorico(dto.getHistorico());
    relatorio.setCliente(cliente);
    relatorio.setOutdoor(outdoor);
    // Atualize outros relacionamentos conforme necessário
  }
}
