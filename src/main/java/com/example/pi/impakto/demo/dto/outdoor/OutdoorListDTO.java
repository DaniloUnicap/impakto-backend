package com.example.pi.impakto.demo.dto.outdoor;

import com.example.pi.impakto.demo.model.Agendamento;
import com.example.pi.impakto.demo.model.Geolocalizacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OutdoorListDTO {

    private Long id;
    private String fotoOutdoor;
    private Geolocalizacao geolocalizacao;
    private String descricao;
    private boolean statusUso;
    private String tipoOutdoor;
    private Agendamento agendamento;
    
}
