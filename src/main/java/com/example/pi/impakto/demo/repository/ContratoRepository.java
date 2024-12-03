package com.example.pi.impakto.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pi.impakto.demo.dto.contrato.ContratoUpdateDTO;
import com.example.pi.impakto.demo.model.Cliente;
import com.example.pi.impakto.demo.model.Contrato;

import jakarta.transaction.Transactional;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE Contrato c SET c = :novoContrato WHERE c.cliente = :cliente")
    public void updateByCliente(@Param("cliente") Cliente cliente, @Param("novoContrato") ContratoUpdateDTO novoContrato);

    public Optional<Contrato> findByCliente(Cliente cliente);
    
}
