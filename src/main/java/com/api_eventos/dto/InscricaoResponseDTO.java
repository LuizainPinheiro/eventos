package com.api_eventos.dto;

import java.time.LocalDate;

public record InscricaoResponseDTO(
        Long id,
        LocalDate dataInscricao,
        Long participanteId,
        Long eventoId
) {
}
