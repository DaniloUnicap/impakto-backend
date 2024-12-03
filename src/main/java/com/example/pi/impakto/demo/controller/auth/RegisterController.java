package com.example.pi.impakto.demo.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pi.impakto.demo.controller.openAPI.RegisterControllerOpenAPI;
import com.example.pi.impakto.demo.dto.usuario.RegisterDTO;
import com.example.pi.impakto.demo.service.auth.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth/register")
public class RegisterController implements RegisterControllerOpenAPI{

    @Autowired RegisterService registerService;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        return registerService.register(data);
    }
}

