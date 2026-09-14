package com.api_eventos.service;

import com.api_eventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }


}
