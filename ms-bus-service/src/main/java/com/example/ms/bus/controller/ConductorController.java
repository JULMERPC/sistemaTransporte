package com.example.ms.bus.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ms.bus.dto.ConductorDTO;
import com.example.ms.bus.entity.Conductor;
import com.example.ms.bus.service.ConductorService;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public List<ConductorDTO> getAll() {
        return conductorService.getAll();
    }

    @PostMapping
    public ConductorDTO create(@RequestBody Conductor conductor) {
        return conductorService.create(conductor);
    }
}