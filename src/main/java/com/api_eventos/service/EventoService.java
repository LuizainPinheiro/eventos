package com.api_eventos.service;

import com.api_eventos.dto.EventoRequestDTO;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.exception.RecursoNaoEncontradoException;
import com.api_eventos.model.Evento;
import com.api_eventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public EventoResponseDTO toResponseDTO(Evento evento){
        return new EventoResponseDTO(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getData(),
                evento.getLocal(),
                evento.getCapacidadeMaxima(),
                evento.getCapacidadeMaxima()-evento.getInscricao().size()
        );
    }

    public EventoResponseDTO criar (EventoRequestDTO dto){
        Evento evento = Evento.builder().nome(dto.nome()).descricao(dto.descricao()).data(dto.data()).local(dto.local()).capacidadeMaxima(dto.capacidadeMaxima()).build();
        Evento salvo = eventoRepository.save(evento);
        return toResponseDTO(salvo);
    }

    public List<EventoResponseDTO> listar (){
        return eventoRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public EventoResponseDTO buscarPorId(Long id){
        return toResponseDTO(eventoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Evento nao encontrado.")));
    }

}
