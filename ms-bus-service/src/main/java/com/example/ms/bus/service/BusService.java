package com.example.ms.bus.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ms.bus.entity.Bus;
import com.example.ms.bus.entity.Conductor;
import com.example.ms.bus.dto.BusDTO;
import com.example.ms.bus.repository.BusRepository;
import com.example.ms.bus.repository.ConductorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    public List<BusDTO> getAll() {
        return busRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BusDTO getById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow();
        return convertToDTO(bus);
    }

    public BusDTO create(Bus bus) {
        return convertToDTO(busRepository.save(bus));
    }

    public BusDTO update(Long id, Bus busDetails) {
        Bus bus = busRepository.findById(id).orElseThrow();
        bus.setPlaca(busDetails.getPlaca());
        bus.setMarca(busDetails.getMarca());
        bus.setModelo(busDetails.getModelo());
        bus.setCapacidad(busDetails.getCapacidad());
        bus.setEstado(busDetails.getEstado());
        if (busDetails.getConductor() != null) {
            bus.setConductor(busDetails.getConductor());
        }
        return convertToDTO(busRepository.save(bus));
    }

    public void delete(Long id) {
        busRepository.deleteById(id);
    }

    public BusDTO assignConductor(Long idBus, Long idConductor) {
        Bus bus = busRepository.findById(idBus).orElseThrow();
        Conductor conductor = conductorRepository.findById(idConductor).orElseThrow();
        bus.setConductor(conductor);
        return convertToDTO(busRepository.save(bus));
    }

    private BusDTO convertToDTO(Bus bus) {
        Long idConductor = bus.getConductor() != null ? bus.getConductor().getId() : null;
        String nombreConductor = bus.getConductor() != null ? bus.getConductor().getNombre() : null;
        return new BusDTO(
                bus.getId(),
                bus.getPlaca(),
                bus.getMarca(),
                bus.getModelo(),
                bus.getCapacidad(),
                bus.getEstado(),
                idConductor,
                nombreConductor
        );
    }
}
