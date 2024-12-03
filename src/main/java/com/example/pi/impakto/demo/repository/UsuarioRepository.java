package com.example.pi.impakto.demo.repository;
import com.example.pi.impakto.demo.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByNomeUsuario(String nomeUsuario);

}