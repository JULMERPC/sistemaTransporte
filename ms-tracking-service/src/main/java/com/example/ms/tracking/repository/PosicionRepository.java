package com.example.ms.tracking.repository;


import com.example.ms.tracking.entity.PosicionTiempoReal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosicionRepository extends JpaRepository<PosicionTiempoReal, Long> {

    @Query(value = "SELECT * FROM posiciones_tiempo_real WHERE id_bus = ?1 ORDER BY timestamp DESC LIMIT 1", nativeQuery = true)
    PosicionTiempoReal findUltimaPosicionByBusId(int idBus);

    @Query(value = "SELECT DISTINCT id_bus FROM posiciones_tiempo_real WHERE timestamp >= NOW() - INTERVAL 5 MINUTE", nativeQuery = true)
    List<Integer> findBusesActivos();
}
