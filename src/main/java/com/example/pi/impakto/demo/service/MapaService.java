package com.example.pi.impakto.demo.service;

import com.example.pi.impakto.demo.dto.mapa.MapaDetailDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaInsertDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaListDTO;
import com.example.pi.impakto.demo.dto.mapa.MapaUpdateDTO;
import com.example.pi.impakto.demo.exception.ResourceNotFoundException;
import com.example.pi.impakto.demo.model.Mapa;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.repository.MapaRepository;
import com.example.pi.impakto.demo.service.converters.MapaDTOConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapaService {

    @Autowired
    private MapaRepository mapaRepository;

    public MapaDetailDTO createMapa(MapaInsertDTO dto) {
        Mapa mapa = MapaDTOConverters.mapaInsertDTOToModel(dto);
        Mapa savedMapa = mapaRepository.save(mapa);
        return MapaDTOConverters.toMapaDetailDTO(savedMapa);
    }

    public MapaDetailDTO getMapaById(Long id) {
        Mapa mapa = mapaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        return MapaDTOConverters.toMapaDetailDTO(mapa);
    }

    public List<MapaListDTO> getAllMapas() {
        return mapaRepository
                .findAll()
                .stream()
                .map(MapaDTOConverters::toMapaListDTO)
                .collect(Collectors.toList());
    }

    public void deleteMapa(Long id) {
        if (!mapaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Mapa não encontrado");
        }
        mapaRepository.deleteById(id);
    }

    public MapaDetailDTO updateMapa(Long id, MapaUpdateDTO dto) {
        Mapa mapa = mapaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        MapaDTOConverters.mapaUpdateDTOToModel(dto, mapa);
        Mapa updatedMapa = mapaRepository.save(mapa);
        return MapaDTOConverters.toMapaDetailDTO(updatedMapa);
    }

    public MapaDetailDTO findByOutdoor(Outdoor outdoor) throws ResourceNotFoundException {
        Mapa mapa = mapaRepository
                .findByOutdoor(outdoor)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        return MapaDTOConverters.toMapaDetailDTO(mapa);
    }

    public void deleteByOutdoor(Outdoor outdoor) throws ResourceNotFoundException {
        Mapa mapa = mapaRepository
                .findByOutdoor(outdoor)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        mapaRepository.delete(mapa);
    }

    public MapaDetailDTO getByGeolocalizacao(String geolocalizacao) throws ResourceNotFoundException {
        Mapa mapa = mapaRepository
                .getByGeolocalizacao(geolocalizacao)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        return MapaDTOConverters.toMapaDetailDTO(mapa);
    }

    public void updateByGeolocalizacao(String geolocalizacao, MapaUpdateDTO dto) throws ResourceNotFoundException {
        Mapa mapa = mapaRepository
                .getByGeolocalizacao(geolocalizacao)
                .orElseThrow(() -> new ResourceNotFoundException("Mapa não encontrado"));

        MapaDTOConverters.mapaUpdateDTOToModel(dto, mapa);
        mapaRepository.save(mapa);
    }
}
