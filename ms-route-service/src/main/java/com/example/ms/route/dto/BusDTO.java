package com.example.ms.route.dto;

import com.example.ms.route.entity.Bus.Estado;

public class BusDTO {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private Integer capacidad;
    private Estado estado;
    private Long idConductor;
    private String nombreConductor;

    public BusDTO() {}

    public BusDTO(Long id, String placa, String marca, String modelo, Integer capacidad, Estado estado, Long idConductor, String nombreConductor) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
        this.idConductor = idConductor;
        this.nombreConductor = nombreConductor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Long idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    // Getters y setters
}
