package com.example.ms.route.repository;


import com.example.ms.route.entity.PuntoRuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntoRutaRepository extends JpaRepository<PuntoRuta, Long> {
    List<PuntoRuta> findByRutaId(Long rutaId);
}
