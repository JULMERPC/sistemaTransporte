package com.example.ms.route.controller;


import com.example.ms.route.entity.Ruta;
import com.example.ms.route.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public List<Ruta> listarRutas() {
        return rutaService.listarRutas();
    }

    @PostMapping
    public Ruta crearRuta(@RequestBody Ruta ruta) {
        return rutaService.crearRuta(ruta);
    }

    @PutMapping("/{id}")
    public Ruta actualizarRuta(@PathVariable Long id, @RequestBody Ruta ruta) {
        return rutaService.actualizarRuta(id, ruta);
    }

    @DeleteMapping("/{id}")
    public void eliminarRuta(@PathVariable Long id) {
        rutaService.eliminarRuta(id);
    }
}
