package com.example.ms.notification.service;


import com.example.ms.notification.dto.PosicionDTO;
import com.example.ms.notification.entity.Notificacion;
import com.example.ms.notification.entity.Notificacion.Tipo;
import com.example.ms.notification.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void enviarNotificacion(Notificacion notif) {
        notificacionRepository.save(notif);
        messagingTemplate.convertAndSend("/topic/notificaciones", notif);
    }

    // Simula verificación de llegada al destino
    public void verificarLlegadaDestino(PosicionDTO posicion) {
        // ⚙️ En una app real, se obtendría el punto destino desde otro microservicio
        double latDestino = -15.499234;
        double lonDestino = -70.126543;

        double distancia = calcularDistancia(
                posicion.getLatitud(), posicion.getLongitud(),
                latDestino, lonDestino
        );

        if (distancia <= 0.05) { // 50 metros
            Notificacion notif = new Notificacion();
            notif.setTipo(Tipo.LLEGADA_DESTINO);
            notif.setIdBus(posicion.getIdBus());
            notif.setMensaje("🚌 Bus " + posicion.getIdBus() + " llegó a destino.");
            enviarNotificacion(notif);
        }
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radio de la Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Retorna distancia en km
    }

    public void marcarComoLeida(Long id) {
        notificacionRepository.findById(id).ifPresent(n -> {
            n.setLeida(true);
            notificacionRepository.save(n);
        });
    }
}
