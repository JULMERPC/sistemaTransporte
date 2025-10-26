package com.example.ms.route.service;


import com.example.ms.route.entity.Ruta;
import com.example.ms.route.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }

    public Ruta obtenerPorId(Long id) {
        return rutaRepository.findById(id).orElse(null);
    }

    public Ruta crearRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Ruta actualizarRuta(Long id, Ruta nuevaRuta) {
        Ruta ruta = obtenerPorId(id);
        if (ruta != null) {
            ruta.setNombre(nuevaRuta.getNombre());
            ruta.setDescripcion(nuevaRuta.getDescripcion());
            ruta.setDistanciaKm(nuevaRuta.getDistanciaKm());
            ruta.setTiempoEstimadoMin(nuevaRuta.getTiempoEstimadoMin());
            ruta.setEstado(nuevaRuta.getEstado());
            return rutaRepository.save(ruta);
        }
        return null;
    }

    public void eliminarRuta(Long id) {
        rutaRepository.deleteById(id);
    }
}
