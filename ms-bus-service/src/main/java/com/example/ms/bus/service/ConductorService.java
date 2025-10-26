package com.example.ms.bus.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ms.bus.repository.ConductorRepository;
import com.example.ms.bus.dto.ConductorDTO;
import com.example.ms.bus.entity.Conductor;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public List<ConductorDTO> getAll() {
        return conductorRepository.findAll().stream()
                .map(c -> new ConductorDTO(c.getId(), c.getNombre(), c.getLicencia(), c.getTelefono(), c.getEmail()))
                .collect(Collectors.toList());
    }

    public ConductorDTO create(Conductor conductor) {
        Conductor saved = conductorRepository.save(conductor);
        return new ConductorDTO(saved.getId(), saved.getNombre(), saved.getLicencia(), saved.getTelefono(), saved.getEmail());
    }
}
