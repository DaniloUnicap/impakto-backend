package com.example.pi.impakto.demo.dto.outdoor;

import com.example.pi.impakto.demo.model.Geolocalizacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OutdoorUpdateDTO {
    
    private String figuraOutdoor;
    private String fotoOutdoor;
    private Geolocalizacao geoLocalizacao;
    private String descricao;
    private boolean statusUso;
    private String tipoOutdoor;

}
