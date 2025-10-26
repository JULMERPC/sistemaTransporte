package com.example.ms.tracking.service;

import com.example.ms.tracking.dto.PosicionDTO;
import com.example.ms.tracking.entity.PosicionTiempoReal;
import com.example.ms.tracking.repository.PosicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private PosicionRepository posicionRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public PosicionTiempoReal registrarPosicion(PosicionDTO dto) {
        PosicionTiempoReal posicion = new PosicionTiempoReal();
        posicion.setIdBus(dto.getIdBus());
        posicion.setLatitud(dto.getLatitud());
        posicion.setLongitud(dto.getLongitud());
        posicion.setVelocidad(dto.getVelocidad());
        posicion.setDireccion(dto.getDireccion());

        PosicionTiempoReal saved = posicionRepository.save(posicion);

        // Emitir por WebSocket
        messagingTemplate.convertAndSend("/topic/tracking", saved);

        return saved;
    }

    public PosicionTiempoReal obtenerUltimaPosicion(int idBus) {
        return posicionRepository.findUltimaPosicionByBusId(idBus);
    }

    public List<Integer> obtenerBusesActivos() {
        return posicionRepository.findBusesActivos();
    }
}
