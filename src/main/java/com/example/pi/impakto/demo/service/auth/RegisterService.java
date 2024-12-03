package com.example.pi.impakto.demo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pi.impakto.demo.dto.usuario.RegisterDTO;
import com.example.pi.impakto.demo.model.Usuario;
import com.example.pi.impakto.demo.repository.UsuarioRepository;

@Service
public class RegisterService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public ResponseEntity register(RegisterDTO data) {
        if (data.senha() == null || data.senha().isEmpty()) {
            return ResponseEntity.badRequest().body("A senha não pode ser nula ou vazia.");
        }

        if (this.repository.findByNomeUsuario(data.nomeUsuario()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe.");
        }

        String encryptedPassword = passwordEncoder.encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nomeUsuario(), encryptedPassword, data.role());

        this.repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}
