package com.api_eventos.dto;

import java.time.LocalDate;

public record InscricaoRequestDTO(
        LocalDate dataInscricao,
        Long eventoId,
        Long participanteId

) {
}
