package com.example.ms.route.util;


import com.example.ms.route.entity.Ruta;
import com.example.ms.route.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RutaSeeder implements CommandLineRunner {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public void run(String... args) {
        if (rutaRepository.count() == 0) {
            List<Ruta> rutas = Arrays.asList(
                    crearRuta("Ruta Centro", "Recorrido principal por el centro de la ciudad", 12.5, 35, "ACTIVA"),
                    crearRuta("Ruta Norte", "Llega hasta los límites norte de la ciudad", 18.0, 45, "ACTIVA"),
                    crearRuta("Ruta Sur", "Conecta el sur con el centro", 15.8, 40, "INACTIVA"),
                    crearRuta("Ruta Express", "Ruta rápida sin muchas paradas", 9.3, 25, "ACTIVA")
            );

            rutaRepository.saveAll(rutas);
            System.out.println("✅ Seeder de Ruta ejecutado correctamente.");
        }
    }

    private Ruta crearRuta(String nombre, String descripcion, double distancia, int tiempo, String estado) {
        Ruta ruta = new Ruta();
        ruta.setNombre(nombre);
        ruta.setDescripcion(descripcion);
        ruta.setDistanciaKm(distancia);
        ruta.setTiempoEstimadoMin(tiempo);
        ruta.setEstado(Ruta.EstadoRuta.valueOf(estado));
        return ruta;
    }
}
