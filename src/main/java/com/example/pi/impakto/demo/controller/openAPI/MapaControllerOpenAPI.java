package com.example.pi.impakto.demo.controller.openAPI;

import java.util.List;

import com.example.pi.impakto.demo.dto.mapa.MapaDetailDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaInsertDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaListDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaUpdateDTO;
import com.example.pi.impakto.demo.exception.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Mapa")
public interface MapaControllerOpenAPI {
    @Operation(summary = "Inserir mapa")
    public MapaDetailDTO createMapa(MapaInsertDTO mapaDTO);

    @Operation(summary = "Pegar mapa pelo id")
    public MapaDetailDTO getMapaById(Long id)
    throws ResourceNotFoundException;

    @Operation(summary = "Listar mapas")
    public List<MapaListDTO> getAllMapas();

    @Operation(summary = "Atualizar mapa pelo id")
    public MapaDetailDTO updateMapa(Long id,MapaUpdateDTO mapaDTO
  ) throws ResourceNotFoundException;

    @Operation(summary = "Deletar mapa pelo id")
    public void deleteMapa(Long id);

    @Operation(summary = "Obter mapa por Geolocalização")
    public MapaDetailDTO findByGeolocalizacao(String geolocalizacao
  ) throws ResourceNotFoundException;

    @Operation(summary = "Atualizar mapa por Geolocalização")
    public void updateOutdoorByCliente(String geolocalizacao);



}
