package com.example.pi.impakto.demo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.pi.impakto.demo.config.security.TokenService;
import com.example.pi.impakto.demo.dto.login.LoginResponseDTO;
import com.example.pi.impakto.demo.dto.usuario.AuthenticationDTO;
import com.example.pi.impakto.demo.model.Usuario;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity login(AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nomeUsuario(), data.senha());

        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
