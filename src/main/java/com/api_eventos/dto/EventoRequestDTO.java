package com.api_eventos.dto;

import java.time.LocalDate;
import java.util.List;

public record EventoRequestDTO(
        String nome,
        String descricao,
        LocalDate data,
        String local,
        Integer capacidadeMaxima
) {

}
