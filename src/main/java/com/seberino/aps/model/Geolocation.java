package com.seberino.aps.model;

import java.time.LocalDateTime;

public class Geolocation {
    private String codigo_ibge;

    private String nome;

    private Boolean capital;

    private String codigo_uf;

    private Double latitude;

    private Double longitude;

    public Geolocation() {
    }

    public Geolocation(String codigo_ibge, String nome, Boolean capital, String codigo_uf, Double latitude, Double longitude) {
        this.codigo_ibge = codigo_ibge;
        this.nome = nome;
        this.capital = capital;
        this.codigo_uf = codigo_uf;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCodigo_ibge() {
        return codigo_ibge;
    }

    public void setCodigo_ibge(String codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public String getCodigo_uf() {
        return codigo_uf;
    }

    public void setCodigo_uf(String codigo_uf) {
        this.codigo_uf = codigo_uf;
    }
}
