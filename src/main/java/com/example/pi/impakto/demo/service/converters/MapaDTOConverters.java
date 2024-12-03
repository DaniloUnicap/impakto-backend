package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.mapa.MapaDetailDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaInsertDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaListDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaUpdateDTO;
import com.example.pi.impakto.demo.model.Mapa;
import java.util.stream.Collectors;

public class MapaDTOConverters {

  // Converte MapaInsertDTO para Mapa (para criação de uma nova entidade)
  public static Mapa mapaInsertDTOToModel(MapaInsertDTO dto) {
    Mapa mapa = new Mapa();
    mapa.setGeolocalizacao(dto.getGeolocalizacao());
    // Aqui, configure os relacionamentos adicionais, se necessário (ex.: outdoor)
    return mapa;
  }

  // Converte Mapa para MapaDetailDTO (para retorno detalhado)
  public static MapaDetailDTO toMapaDetailDTO(Mapa mapa) {
    MapaDetailDTO dto = new MapaDetailDTO();
    dto.setId(mapa.getId());
    dto.setGeolocalizacao(mapa.getGeolocalizacao());
    dto.setOutdoorIds(
      mapa.getOutdoor() != null
        ? mapa
          .getOutdoor()
          .stream()
          .map(outdoor -> outdoor.getId())
          .collect(Collectors.toList())
        : null
    );
    // Relacione outros dados, como agendamento, se necessário
    return dto;
  }

  // Converte Mapa para MapaListDTO (para listagens simples)
  public static MapaListDTO toMapaListDTO(Mapa mapa) {
    MapaListDTO dto = new MapaListDTO();
    dto.setId(mapa.getId());
    dto.setGeolocalizacao(mapa.getGeolocalizacao());
    return dto;
  }

  // Atualiza a entidade Mapa com os valores de MapaUpdateDTO
  public static void mapaUpdateDTOToModel(MapaUpdateDTO dto, Mapa mapa) {
    mapa.setGeolocalizacao(dto.getGeolocalizacao());
    // Atualize outros relacionamentos, se necessário (ex.: outdoor)
  }
}
