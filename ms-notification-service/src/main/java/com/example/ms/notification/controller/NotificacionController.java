package com.example.ms.notification.controller;


import com.example.ms.notification.dto.PosicionDTO;
import com.example.ms.notification.entity.Notificacion;
import com.example.ms.notification.repository.NotificacionRepository;
import com.example.ms.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    @PutMapping("/{id}/leer")
    public void marcarLeida(@PathVariable Long id) {
        notificationService.marcarComoLeida(id);
    }

    @PostMapping("/verificar")
    public void verificarLlegada(@RequestBody PosicionDTO posicion) {
        notificationService.verificarLlegadaDestino(posicion);
    }
}
