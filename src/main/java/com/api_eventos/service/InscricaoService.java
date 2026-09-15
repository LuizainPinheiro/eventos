package com.api_eventos.service;

import com.api_eventos.dto.InscricaoResponseDTO;
import com.api_eventos.model.Inscricao;
import com.api_eventos.repository.EventoRepository;
import com.api_eventos.repository.InscricaoRepository;
import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final ParticipanteRepository participanteRepository;
    private final EventoRepository eventoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository, ParticipanteRepository participanteRepository, EventoRepository eventoRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.participanteRepository = participanteRepository;
        this.eventoRepository = eventoRepository;
    }

    public List<InscricaoResponseDTO> listar() {
        return inscricaoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public InscricaoResponseDTO buscarPorId(Long id) {
        return toDTO(inscricaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada com o id " + id)));
    }

    public InscricaoResponseDTO inscrever(LocalDate dataInscricao, Long participanteId, Long eventoId) {
        var participanteCadastrado = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado com o id " + participanteId));

        var eventoCadastrado = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com o id " + eventoId));

        boolean existeConflito = inscricaoRepository.existsByDataInscricaoAndParticipanteIdAndEventoId(
                dataInscricao, participanteId, eventoId
        );

        if (existeConflito) {
            throw new RuntimeException("Inscrição não disponível");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setDataInscricao(dataInscricao);
        inscricao.setParticipante(participanteCadastrado);
        inscricao.setEvento(eventoCadastrado);

        Inscricao salva = inscricaoRepository.save(inscricao);
        return toDTO(salva);
    }

    private InscricaoResponseDTO toDTO(Inscricao inscricao) {
        return new InscricaoResponseDTO(
                inscricao.getId(),
                inscricao.getDataInscricao(),
                inscricao.getParticipante().getId(),
                inscricao.getEvento().getId()
        );
    }
}