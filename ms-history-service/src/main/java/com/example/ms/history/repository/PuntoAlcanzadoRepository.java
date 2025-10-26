package com.example.ms.history.repository;


import com.example.ms.history.entity.PuntoAlcanzado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntoAlcanzadoRepository extends JpaRepository<PuntoAlcanzado, Long> {
    List<PuntoAlcanzado> findByRecorridoId(Long idRecorrido);
}
