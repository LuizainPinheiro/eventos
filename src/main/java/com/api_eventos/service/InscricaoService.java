package com.api_eventos.service;

import com.api_eventos.model.Evento;
import com.api_eventos.model.Inscricao;
import com.api_eventos.repository.EventoRepository;
import com.api_eventos.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    private final ParticipanteService participanteService;
    private final EventoService eventoService;
    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;

    public InscricaoService(ParticipanteService participanteService, EventoService eventoService, InscricaoRepository inscricaoRepository, EventoRepository eventoRepository) {
        this.participanteService = participanteService;
        this.eventoService = eventoService;
        this.inscricaoRepository = inscricaoRepository;
        this.eventoRepository = eventoRepository;
    }

    public Inscricao inscrever (Long participanteId, Long eventoId {
        var participanteQueVeioDoBanco = participanteService.buscarPorId(participanteId);
        var eventoQueVeioDoBanco = eventoService.buscarPorId(eventoId);
        Inscricao inscricao = Inscricao.builder().;

    }
}
