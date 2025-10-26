package com.example.ms.history.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class ConductorSeeder implements CommandLineRunner {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public void run(String... args) {
        if (conductorRepository.count() == 0) {
            List<Conductor> conductores = Arrays.asList(
                    crearConductor("Juan Pérez", "LIC-001-A", "987654321", "juan.perez@example.com"),
                    crearConductor("María Gómez", "LIC-002-B", "912345678", "maria.gomez@example.com"),
                    crearConductor("Carlos Rivera", "LIC-003-C", "900123456", "carlos.rivera@example.com")
            );

            conductorRepository.saveAll(conductores);
            System.out.println("✅ Seeder de Conductor ejecutado correctamente.");
        }
    }

    private Conductor crearConductor(String nombre, String licencia, String telefono, String email) {
        LocalDateTime now = LocalDateTime.now();
        Conductor conductor = new Conductor();
        conductor.setNombre(nombre);
        conductor.setLicencia(licencia);
        conductor.setTelefono(telefono);
        conductor.setEmail(email);
        conductor.setCreatedAt(now);
        return conductor;
    }
}
