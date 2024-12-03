package com.example.pi.impakto.demo.dto.mapa;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MapaInsertDTO {

  private String geolocalizacao;
  private List<Long> outdoorIds;
}
