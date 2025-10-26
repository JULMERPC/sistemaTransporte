package com.example.ms.notification.util;


import com.example.ms.notification.entity.Notificacion;
import com.example.ms.notification.repository.NotificacionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @PostConstruct
    public void init() {
        if (notificacionRepository.count() == 0) {
            Notificacion n1 = new Notificacion();
            n1.setTipo(Notificacion.Tipo.RETRASO);
            n1.setIdBus(3);
            n1.setMensaje("Bus 3 presenta retraso de 10 minutos.");

            Notificacion n2 = new Notificacion();
            n2.setTipo(Notificacion.Tipo.ALERTA);
            n2.setIdBus(5);
            n2.setMensaje("Bus 5 fuera de ruta.");

            Notificacion n3 = new Notificacion();
            n3.setTipo(Notificacion.Tipo.LLEGADA_DESTINO);
            n3.setIdBus(1);
            n3.setMensaje("Bus 1 llegó a destino final.");

            notificacionRepository.saveAll(Arrays.asList(n1, n2, n3));
            System.out.println("✅ Datos iniciales cargados en ms-notification-service");
        }
    }
}
