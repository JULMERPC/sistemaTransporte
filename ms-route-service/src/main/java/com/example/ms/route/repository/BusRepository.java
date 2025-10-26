package com.example.ms.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms.route.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
}