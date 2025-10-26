package com.example.ms.route.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ms.route.dto.ConductorDTO;
import com.example.ms.route.entity.Conductor;
import com.example.ms.route.service.ConductorService;

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