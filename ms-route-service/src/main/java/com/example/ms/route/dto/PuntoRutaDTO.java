package com.example.ms.route.dto;


import lombok.Data;

@Data
public class PuntoRutaDTO {
    private Long id;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private Integer orden;
    private Boolean esDestino;
    private Long idRuta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Boolean getEsDestino() {
        return esDestino;
    }

    public void setEsDestino(Boolean esDestino) {
        this.esDestino = esDestino;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }
}
