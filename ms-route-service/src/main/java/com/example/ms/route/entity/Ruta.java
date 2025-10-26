package com.example.ms.route.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "rutas")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double distanciaKm;
    private Integer tiempoEstimadoMin;

    @Enumerated(EnumType.STRING)
    private EstadoRuta estado;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuntoRuta> puntos;

    public enum EstadoRuta {
        ACTIVA, INACTIVA
    }


    public Ruta() {
    }

    public Ruta(Long id, String nombre, String descripcion, Double distanciaKm, Integer tiempoEstimadoMin, EstadoRuta estado, List<PuntoRuta> puntos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distanciaKm = distanciaKm;
        this.tiempoEstimadoMin = tiempoEstimadoMin;
        this.estado = estado;
        this.puntos = puntos;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public Integer getTiempoEstimadoMin() {
        return tiempoEstimadoMin;
    }

    public void setTiempoEstimadoMin(Integer tiempoEstimadoMin) {
        this.tiempoEstimadoMin = tiempoEstimadoMin;
    }

    public EstadoRuta getEstado() {
        return estado;
    }

    public void setEstado(EstadoRuta estado) {
        this.estado = estado;
    }

    public List<PuntoRuta> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<PuntoRuta> puntos) {
        this.puntos = puntos;
    }
}
