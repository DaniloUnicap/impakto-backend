package com.example.pi.impakto.demo.repository;
 
import com.example.pi.impakto.demo.model.Mapa;
import com.example.pi.impakto.demo.model.Outdoor;

import jakarta.transaction.Transactional;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
@Repository
public interface MapaRepository extends JpaRepository<Mapa, Long> {
 
    // public void insertGeolocalizacao(String geolocalizacao);
 
    public void deleteByOutdoor(Outdoor outdoor);
 
    public Optional<Mapa> getByGeolocalizacao(String geolocalizacao);

    @Transactional
    @Modifying
    @Query("UPDATE Mapa m SET m.geolocalizacao = :mapaAtualizado WHERE m.geolocalizacao = :geolocalizacao")
    public void updateByGeolocalizacao(@Param("geolocalizacao") String geolocalizacao, @Param("mapaAtualizado") String mapaAtualizado);
 
 
    public Optional<Mapa> findByOutdoor(Outdoor outdoor);
 
   
}