package com.example.pi.impakto.demo.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pi.impakto.demo.controller.openAPI.LoginControllerOpenAPI;
import com.example.pi.impakto.demo.dto.usuario.AuthenticationDTO;
import com.example.pi.impakto.demo.service.auth.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth/login")
public class LoginController implements LoginControllerOpenAPI{
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        return loginService.login(data);
    }
}
