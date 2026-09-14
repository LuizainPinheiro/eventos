package com.api_eventos.controller;

import com.api_eventos.dto.EventoRequestDTO;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<EventoResponseDTO> listar(){
        return eventoService.listar();
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> criar (@RequestBody EventoRequestDTO eventoRequestDTO){
        EventoResponseDTO eventoSalvo = eventoService.criar(eventoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
    }

    @GetMapping("/{id}")
    public EventoResponseDTO buscarPorId(@PathVariable Long id){
        return eventoService.buscarPorId(id);
    }
}
