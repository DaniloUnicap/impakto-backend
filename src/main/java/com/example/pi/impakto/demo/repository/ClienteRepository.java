package com.example.pi.impakto.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pi.impakto.demo.dto.cliente.ClienteUpdateDTO;
import com.example.pi.impakto.demo.model.Cliente;

import jakarta.transaction.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

    @Transactional
    @Modifying
    @Query("UPDATE Cliente c SET c.nome = :clienteAtualizado WHERE c.nome = :nome")
    public void updateByNome(@Param("nome") String nome, @Param("clienteAtualizado") ClienteUpdateDTO clienteAtualizado);

    public Optional<Cliente> findByNome(String nome); 
    
}
