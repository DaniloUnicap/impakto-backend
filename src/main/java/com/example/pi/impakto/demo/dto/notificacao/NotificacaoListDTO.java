package com.example.pi.impakto.demo.dto.notificacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.pi.impakto.demo.model.Usuario;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class NotificacaoListDTO {

    private Long id;
    private String mensagem;
    private String titulo;
    private LocalTime hora;
    private LocalDate data;
    private Usuario usuario; 
}
