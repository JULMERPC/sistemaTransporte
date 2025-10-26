package com.example.ms.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms.bus.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
}