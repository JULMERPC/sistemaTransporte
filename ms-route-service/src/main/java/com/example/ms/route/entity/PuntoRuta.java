package com.example.ms.route.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "puntos_ruta")
public class PuntoRuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double latitud;
    private Double longitud;
    private Integer orden;
    private Boolean esDestino;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;


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

    public Boolean getEsDestino() {
        return esDestino;
    }

    public void setEsDestino(Boolean esDestino) {
        this.esDestino = esDestino;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
