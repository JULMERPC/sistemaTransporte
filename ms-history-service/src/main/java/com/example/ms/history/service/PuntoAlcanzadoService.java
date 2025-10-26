package com.example.ms.history.service;


import com.example.ms.history.entity.PuntoAlcanzado;
import com.example.ms.history.repository.PuntoAlcanzadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoAlcanzadoService {

    @Autowired
    private PuntoAlcanzadoRepository puntoAlcanzadoRepository;

    public List<PuntoAlcanzado> puntosPorRecorrido(Long idRecorrido) {
        return puntoAlcanzadoRepository.findByRecorridoId(idRecorrido);
    }
}
