package com.example.ms.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms.route.entity.Conductor;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}