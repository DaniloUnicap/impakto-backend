package com.example.pi.impakto.demo.dto.notificacao;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class NotificacaoUpdateDTO {

    private String mensagem;
    private String titulo;
    private LocalTime hora;
    private LocalDate data;
    private Long idUsuario; 
}
