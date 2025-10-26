package com.example.ms.history.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "recorridos")
public class Recorrido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idBus;
    private Integer idRuta;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Double distanciaRecorridaKm;
    private Integer duracionMin;

    @Enumerated(EnumType.STRING)
    private EstadoRecorrido estado;

    @OneToMany(mappedBy = "recorrido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuntoAlcanzado> puntosAlcanzados;

    public enum EstadoRecorrido {
        EN_CURSO, COMPLETADO, CANCELADO
    }


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

    public Double getDistanciaRecorridaKm() {
        return distanciaRecorridaKm;
    }

    public void setDistanciaRecorridaKm(Double distanciaRecorridaKm) {
        this.distanciaRecorridaKm = distanciaRecorridaKm;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public EstadoRecorrido getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecorrido estado) {
        this.estado = estado;
    }

    public List<PuntoAlcanzado> getPuntosAlcanzados() {
        return puntosAlcanzados;
    }

    public void setPuntosAlcanzados(List<PuntoAlcanzado> puntosAlcanzados) {
        this.puntosAlcanzados = puntosAlcanzados;
    }
}
