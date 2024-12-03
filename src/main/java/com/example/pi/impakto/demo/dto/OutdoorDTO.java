package com.example.pi.impakto.demo.dto;


public class OutdoorDTO {
    
    private Long id;
    private String figuraOutdoor;
    private String fotoOutdoor;
    private String geoLocalizacao;
    // private String idOutdoor;
    private String descricao;
    private boolean statusUso;
    private String tipoOutdoor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiguraOutdoor() {
        return figuraOutdoor;
    }

    public void setFiguraOutdoor(String figuraOutdoor) {
        this.figuraOutdoor = figuraOutdoor;
    }

    public String getFotoOutdoor() {
        return fotoOutdoor;
    }

    public void setFotoOutdoor(String fotoOutdoor) {
        this.fotoOutdoor = fotoOutdoor;
    }

    public String getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(String geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

    // public String getIdOutdoor() {
    //     return idOutdoor;
    // }

    // public void setIdOutdoor(String idOutdoor) {
    //     this.idOutdoor = idOutdoor;
    // }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatusUso() {
        return statusUso;
    }

    public void setStatusUso(boolean statusUso) {
        this.statusUso = statusUso;
    }


    public String getTipoOutdoor() {
        return tipoOutdoor;
    }

    public void setTipoOutdoor(String tipoOutdoor) {
        this.tipoOutdoor = tipoOutdoor;
    }

}
