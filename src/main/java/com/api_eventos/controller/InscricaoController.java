package com.api_eventos.controller;

import com.api_eventos.dto.InscricaoRequestDTO;
import com.api_eventos.dto.InscricaoResponseDTO;
import com.api_eventos.model.Inscricao;
import com.api_eventos.service.InscricaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/inscricao")
public class InscricaoController {

    public final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public InscricaoResponseDTO inscrever(@RequestBody InscricaoRequestDTO dto) {
        return inscricaoService.inscrever(dto.dataInscricao(), dto.participanteId(), dto.eventoId());
    }

    @GetMapping
    public List<InscricaoResponseDTO> listar() {
        return inscricaoService.listar();
    }

    @GetMapping("/{id}")
    public InscricaoResponseDTO buscarPorId(@PathVariable Long id) {

        return inscricaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        inscricaoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }

}

