package com.example.ms.tracking.controller;


import com.example.ms.tracking.dto.PosicionDTO;
import com.example.ms.tracking.entity.PosicionTiempoReal;
import com.example.ms.tracking.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping("/posicion")
    public PosicionTiempoReal recibirPosicion(@RequestBody PosicionDTO dto) {
        return trackingService.registrarPosicion(dto);
    }

    @GetMapping("/bus/{id}/ultima-posicion")
    public PosicionTiempoReal ultimaPosicion(@PathVariable("id") int idBus) {
        return trackingService.obtenerUltimaPosicion(idBus);
    }

    @GetMapping("/buses/activos")
    public List<Integer> busesActivos() {
        return trackingService.obtenerBusesActivos();
    }
}
