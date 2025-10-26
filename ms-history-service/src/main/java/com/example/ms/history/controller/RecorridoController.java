package com.example.ms.history.controller;


import com.example.ms.history.entity.Recorrido;
import com.example.ms.history.service.RecorridoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recorridos")
public class RecorridoController {

    @Autowired
    private RecorridoService recorridoService;

    @GetMapping
    public List<Recorrido> listarRecorridos() {
        return recorridoService.listarRecorridos();
    }

    @GetMapping("/{id}")
    public Recorrido obtenerDetalle(@PathVariable Long id) {
        return recorridoService.obtenerPorId(id);
    }

    @GetMapping("/bus/{idBus}/historial")
    public List<Recorrido> historialPorBus(@PathVariable Integer idBus) {
        return recorridoService.historialPorBus(idBus);
    }
}
