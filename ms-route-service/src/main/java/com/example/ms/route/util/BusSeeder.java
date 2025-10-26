package com.example.ms.route.util;


import com.example.ms.route.entity.Bus;
import com.example.ms.route.entity.Conductor;
import com.example.ms.route.repository.BusRepository;
import com.example.ms.route.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class BusSeeder implements CommandLineRunner {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public void run(String... args) {
        if (busRepository.count() == 0) {

            // Buscar conductores existentes para asignar
            List<Conductor> conductores = conductorRepository.findAll();
            Conductor c1 = conductores.size() > 0 ? conductores.get(0) : null;
            Conductor c2 = conductores.size() > 1 ? conductores.get(1) : null;

            List<Bus> buses = Arrays.asList(
                    crearBus("ABC-123", "Mercedes", "Sprinter", 30, Bus.Estado.ACTIVO, c1),
                    crearBus("XYZ-789", "Volvo", "B340", 45, Bus.Estado.MANTENIMIENTO, c2),
                    crearBus("LMN-456", "Toyota", "Coaster", 25, Bus.Estado.INACTIVO, null)
            );

            busRepository.saveAll(buses);
            System.out.println("✅ Seeder de Bus ejecutado correctamente.");
        }
    }

    private Bus crearBus(String placa, String marca, String modelo, int capacidad, Bus.Estado estado, Conductor conductor) {
        LocalDateTime now = LocalDateTime.now();
        Bus bus = new Bus();
        bus.setPlaca(placa);
        bus.setMarca(marca);
        bus.setModelo(modelo);
        bus.setCapacidad(capacidad);
        bus.setEstado(estado);
        bus.setConductor(conductor);
        bus.setCreatedAt(now);
        bus.setUpdatedAt(now);
        return bus;
    }
}
