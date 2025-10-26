package com.example.ms.route.repository;


import com.example.ms.route.entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
    Optional<Ruta> findByNombre(String nombre);
}
