package com.example.ms.bus.dto;


public class ConductorDTO {

    private Long id;
    private String nombre;
    private String licencia;
    private String telefono;
    private String email;

    public ConductorDTO() {}

    public ConductorDTO(Long id, String nombre, String licencia, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.licencia = licencia;
        this.telefono = telefono;
        this.email = email;
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

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getters y setters
}
