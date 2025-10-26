package com.example.ms.history.controller;


import com.example.ms.history.entity.PuntoAlcanzado;
import com.example.ms.history.service.PuntoAlcanzadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recorridos/{idRecorrido}/puntos-alcanzados")
public class PuntoAlcanzadoController {

    @Autowired
    private PuntoAlcanzadoService puntoAlcanzadoService;

    @GetMapping
    public List<PuntoAlcanzado> listarPuntos(@PathVariable Long idRecorrido) {
        return puntoAlcanzadoService.puntosPorRecorrido(idRecorrido);
    }
}
