package com.example.ms.route.service;


import com.example.ms.route.entity.PuntoRuta;
import com.example.ms.route.entity.Ruta;
import com.example.ms.route.repository.PuntoRutaRepository;
import com.example.ms.route.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoRutaService {

    @Autowired
    private PuntoRutaRepository puntoRutaRepository;

    @Autowired
    private RutaRepository rutaRepository;

    public List<PuntoRuta> listarPorRuta(Long rutaId) {
        return puntoRutaRepository.findByRutaId(rutaId);
    }

    public PuntoRuta agregarPunto(Long rutaId, PuntoRuta punto) {
        Ruta ruta = rutaRepository.findById(rutaId).orElse(null);
        if (ruta != null) {
            punto.setRuta(ruta);
            return puntoRutaRepository.save(punto);
        }
        return null;
    }
}
