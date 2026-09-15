package com.api_eventos.service;

import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.dto.ParticipanteRequestDTO;
import com.api_eventos.dto.ParticipanteResponseDTO;
import com.api_eventos.exception.EmailJaCadastradoException;
import com.api_eventos.exception.RecursoNaoEncontradoException;
import com.api_eventos.model.Participante;
import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public ParticipanteResponseDTO cadastrar(ParticipanteRequestDTO dto) {

        if (participanteRepository.existsByEmail(dto.email())) {
            throw new EmailJaCadastradoException("Já existe um participante cadastrado com o e-mail: " + dto.email());
        }

        Participante participante = new Participante();
        participante.setNome(dto.nome());
        participante.setEmail(dto.email());
        Participante salvo = participanteRepository.save(participante);
        return toDTO(salvo);
    }

    public List<ParticipanteResponseDTO> listar (){
        return participanteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ParticipanteResponseDTO buscarPorId(Long id){
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Participante não encontrado com o id: " + id));
       return toDTO(participante);
    }

    private ParticipanteResponseDTO toDTO(Participante participante) {
        return new ParticipanteResponseDTO(
                participante.getId(),
                participante.getNome(),
                participante.getEmail()
        );
    }
}