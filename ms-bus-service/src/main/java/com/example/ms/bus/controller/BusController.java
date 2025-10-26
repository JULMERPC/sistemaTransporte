package com.example.ms.bus.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ms.bus.entity.Bus;
import com.example.ms.bus.repository.BusRepository;
import com.example.ms.bus.repository.ConductorRepository;
import com.example.ms.bus.dto.BusDTO;
import com.example.ms.bus.service.BusService;


import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<BusDTO> getAll() {
        return busService.getAll();
    }

    @GetMapping("/{id}")
    public BusDTO getById(@PathVariable Long id) {
        return busService.getById(id);
    }

    @PostMapping
    public BusDTO create(@RequestBody Bus bus) {
        return busService.create(bus);
    }

    @PutMapping("/{id}")
    public BusDTO update(@PathVariable Long id, @RequestBody Bus bus) {
        return busService.update(id, bus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        busService.delete(id);
    }

    @PutMapping("/{idBus}/asignar/{idConductor}")
    public BusDTO assignConductor(@PathVariable Long idBus, @PathVariable Long idConductor) {
        return busService.assignConductor(idBus, idConductor);
    }
}