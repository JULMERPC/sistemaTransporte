package com.example.ms.history.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "puntos_alcanzados")
public class PuntoAlcanzado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idPuntoRuta;
    private LocalDateTime horaLlegada;
    private Double latitud;
    private Double longitud;

    @ManyToOne
    @JoinColumn(name = "id_recorrido")
    private Recorrido recorrido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }
}
