package com.example.ms.history.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PuntoAlcanzadoDTO {
    private Long id;
    private Long idRecorrido;
    private Integer idPuntoRuta;
    private LocalDateTime horaLlegada;
    private Double latitud;
    private Double longitud;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRecorrido() {
        return idRecorrido;
    }

    public void setIdRecorrido(Long idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    public Integer getIdPuntoRuta() {
        return idPuntoRuta;
    }

    public void setIdPuntoRuta(Integer idPuntoRuta) {
        this.idPuntoRuta = idPuntoRuta;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
