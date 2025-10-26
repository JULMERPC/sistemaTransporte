package com.example.ms.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms.bus.entity.Conductor;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}