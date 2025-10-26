package com.example.ms.tracking.util;

import com.example.ms.tracking.entity.PosicionTiempoReal;
import com.example.ms.tracking.repository.PosicionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder {

    @Autowired
    private PosicionRepository posicionRepository;

    @PostConstruct
    public void init() {
        if (posicionRepository.count() == 0) {
            PosicionTiempoReal p1 = new PosicionTiempoReal();
            p1.setIdBus(1);
            p1.setLatitud(-15.493821);
            p1.setLongitud(-70.129875);
            p1.setVelocidad(45.3);
            p1.setDireccion(180);

            PosicionTiempoReal p2 = new PosicionTiempoReal();
            p2.setIdBus(2);
            p2.setLatitud(-15.495642);
            p2.setLongitud(-70.131022);
            p2.setVelocidad(38.9);
            p2.setDireccion(90);

            PosicionTiempoReal p3 = new PosicionTiempoReal();
            p3.setIdBus(3);
            p3.setLatitud(-15.496789);
            p3.setLongitud(-70.128456);
            p3.setVelocidad(50.0);
            p3.setDireccion(270);

            posicionRepository.saveAll(Arrays.asList(p1, p2, p3));
            System.out.println("✅ Datos iniciales cargados en ms-tracking-service");
        }
    }
}
