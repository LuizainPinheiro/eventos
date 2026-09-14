package com.api_eventos.controller;

import com.api_eventos.dto.ParticipanteRequestDTO;
import com.api_eventos.dto.ParticipanteResponseDTO;
import com.api_eventos.service.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService participanteService;


    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> cadastrar(@Valid @RequestBody ParticipanteRequestDTO dto){
        ParticipanteResponseDTO salvo = participanteService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<ParticipanteResponseDTO> listar(){
        return participanteService.listar();
    }

    @GetMapping("/{id}")
    public ParticipanteResponseDTO buscarPorId(@PathVariable Long id){
        return participanteService.buscarPorId(id);
    }
}
