package com.example.pi.impakto.demo.repository;
 
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Relatorio;

import jakarta.transaction.Transactional;

import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
 
  public void deleteByTituloRelatorio(String tituloRelatorio);
 
  public Optional<Relatorio> getByTituloRelatorio(String tituloRelatorio);
 
  @Transactional
  @Modifying
  @Query("UPDATE Relatorio r SET r.tituloRelatorio = :novoRelatorio WHERE r.tituloRelatorio = :tituloRelatorio")
  public void updateByTitulo(@Param("tituloRelatorio") String tituloRelatorio, @Param("novoRelatorio") Relatorio novoRelatorio);

  public Optional<Relatorio> findByCliente(Cliente cliente);


  @Transactional
  @Modifying
  @Query("UPDATE Relatorio r SET r.cliente = :novoRelatorio WHERE r.cliente = :cliente")
  public void updateByCliente(@Param("cliente") Cliente cliente, @Param("novoRelatorio") Relatorio novoRelatorio);


  
}