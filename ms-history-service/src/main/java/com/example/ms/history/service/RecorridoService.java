package com.example.ms.history.service;


import com.example.ms.history.entity.Recorrido;
import com.example.ms.history.repository.RecorridoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecorridoService {

    @Autowired
    private RecorridoRepository recorridoRepository;

    public List<Recorrido> listarRecorridos() {
        return recorridoRepository.findAll();
    }

    public Recorrido obtenerPorId(Long id) {
        return recorridoRepository.findById(id).orElse(null);
    }

    public List<Recorrido> historialPorBus(Integer idBus) {
        return recorridoRepository.findByIdBus(idBus);
    }
}
