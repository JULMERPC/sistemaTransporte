package com.example.ms.history.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecorridoDTO {
    private Long id;
    private Integer idBus;
    private Integer idRuta;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double distanciaRecorridaKm;
    private Integer duracionMin;
    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Double getDistanciaRecorridaKm() {
        return distanciaRecorridaKm;
    }

    public void setDistanciaRecorridaKm(Double distanciaRecorridaKm) {
        this.distanciaRecorridaKm = distanciaRecorridaKm;
    }
}
