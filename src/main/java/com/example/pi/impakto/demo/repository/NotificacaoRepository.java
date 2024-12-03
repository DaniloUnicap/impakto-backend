package com.example.pi.impakto.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pi.impakto.demo.model.Notificacao;
import com.example.pi.impakto.demo.model.Usuario;
 

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    public Optional<Notificacao> findByUsuario(Usuario usuario);

}

