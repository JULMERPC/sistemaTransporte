package com.example.ms.route.util;

import com.example.ms.route.entity.PuntoRuta;
import com.example.ms.route.entity.Ruta;
import com.example.ms.route.repository.PuntoRutaRepository;
import com.example.ms.route.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PuntoRutaSeeder implements CommandLineRunner {

    @Autowired
    private PuntoRutaRepository puntoRutaRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public void run(String... args) {
        if (puntoRutaRepository.count() == 0) {
            Optional<Ruta> rutaCentro = rutaRepository.findByNombre("Ruta Centro");
            Optional<Ruta> rutaNorte = rutaRepository.findByNombre("Ruta Norte");

            if (rutaCentro.isPresent() && rutaNorte.isPresent()) {
                List<PuntoRuta> puntos = Arrays.asList(
                        crearPunto("Paradero Plaza", -15.498, -70.125, 1, false, rutaCentro.get()),
                        crearPunto("Av. San Martín", -15.505, -70.130, 2, false, rutaCentro.get()),
                        crearPunto("Terminal Sur", -15.520, -70.145, 3, true, rutaCentro.get()),

                        crearPunto("Mercado Norte", -15.470, -70.110, 1, false, rutaNorte.get()),
                        crearPunto("Universidad", -15.480, -70.115, 2, false, rutaNorte.get()),
                        crearPunto("Puente Viejo", -15.490, -70.120, 3, true, rutaNorte.get())
                );

                puntoRutaRepository.saveAll(puntos);
                System.out.println("✅ Seeder de Puntos de Ruta ejecutado correctamente.");
            }
        }
    }

    private PuntoRuta crearPunto(String nombre, double lat, double lon, int orden, boolean destino, Ruta ruta) {
        PuntoRuta punto = new PuntoRuta();
        punto.setNombre(nombre);
        punto.setLatitud(lat);
        punto.setLongitud(lon);
        punto.setOrden(orden);
        punto.setEsDestino(destino);
        punto.setRuta(ruta);
        return punto;
    }
}
