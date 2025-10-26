package com.example.ms.history.util;


import com.example.ms.history.entity.Recorrido;
import com.example.ms.history.entity.PuntoAlcanzado;
import com.example.ms.history.repository.RecorridoRepository;
import com.example.ms.history.repository.PuntoAlcanzadoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataSeeder {

    @Autowired
    private RecorridoRepository recorridoRepository;

    @Autowired
    private PuntoAlcanzadoRepository puntoAlcanzadoRepository;

    @PostConstruct
    public void init() {
        if (recorridoRepository.count() == 0) {
            // 🚍 Crear recorridos iniciales
            Recorrido r1 = new Recorrido();
            r1.setIdBus(1);
            r1.setIdRuta(2);
            r1.setFechaInicio(LocalDateTime.now().minusHours(2));
            r1.setFechaFin(LocalDateTime.now());
            r1.setDistanciaRecorridaKm(15.7);
            r1.setDuracionMin(120);
            r1.setEstado(Recorrido.EstadoRecorrido.valueOf("COMPLETADO"));

            Recorrido r2 = new Recorrido();
            r2.setIdBus(2);
            r2.setIdRuta(3);
            r2.setFechaInicio(LocalDateTime.now().minusMinutes(30));
            r2.setDistanciaRecorridaKm(5.2);
            r2.setDuracionMin(30);
            r2.setEstado(Recorrido.EstadoRecorrido.valueOf("EN_CURSO"));

            recorridoRepository.saveAll(Arrays.asList(r1, r2));

            // 📍 Crear puntos alcanzados para el primer recorrido
            PuntoAlcanzado p1 = new PuntoAlcanzado();
            p1.setRecorrido(r1);
            p1.setIdPuntoRuta(1);
            p1.setHoraLlegada(LocalDateTime.now().minusHours(2));
            p1.setLatitud(-15.498765);
            p1.setLongitud(-70.127845);

            PuntoAlcanzado p2 = new PuntoAlcanzado();
            p2.setRecorrido(r1);
            p2.setIdPuntoRuta(2);
            p2.setHoraLlegada(LocalDateTime.now().minusHours(1).minusMinutes(20));
            p2.setLatitud(-15.499234);
            p2.setLongitud(-70.126543);

            PuntoAlcanzado p3 = new PuntoAlcanzado();
            p3.setRecorrido(r1);
            p3.setIdPuntoRuta(3);
            p3.setHoraLlegada(LocalDateTime.now().minusMinutes(10));
            p3.setLatitud(-15.500100);
            p3.setLongitud(-70.125000);

            puntoAlcanzadoRepository.saveAll(Arrays.asList(p1, p2, p3));

            System.out.println("✅ Datos iniciales cargados en ms-history-service");
        }
    }
}
