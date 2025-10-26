package com.example.ms.route.controller;


import com.example.ms.route.entity.PuntoRuta;
import com.example.ms.route.service.PuntoRutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas/{rutaId}/puntos")
public class PuntoRutaController {

    @Autowired
    private PuntoRutaService puntoRutaService;

    @GetMapping
    public List<PuntoRuta> listarPuntos(@PathVariable Long rutaId) {
        return puntoRutaService.listarPorRuta(rutaId);
    }

    @PostMapping
    public PuntoRuta agregarPunto(@PathVariable Long rutaId, @RequestBody PuntoRuta punto) {
        return puntoRutaService.agregarPunto(rutaId, punto);
    }
}
