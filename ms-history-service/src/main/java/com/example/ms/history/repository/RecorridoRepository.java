package com.example.ms.history.repository;


import com.example.ms.history.entity.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecorridoRepository extends JpaRepository<Recorrido, Long> {
    List<Recorrido> findByIdBus(Integer idBus);
}
