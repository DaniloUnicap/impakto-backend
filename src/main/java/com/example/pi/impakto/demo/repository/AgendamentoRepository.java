package com.example.pi.impakto.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.pi.impakto.demo.model.Agendamento;
import com.example.pi.impakto.demo.model.Cliente;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    public Optional<Agendamento> findByCliente(Cliente cliente);
 
}