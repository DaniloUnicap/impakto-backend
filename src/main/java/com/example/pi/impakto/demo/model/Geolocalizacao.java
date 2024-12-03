package com.example.pi.impakto.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Geolocalizacao {
    private double latitude;
    private double longitude;
}
