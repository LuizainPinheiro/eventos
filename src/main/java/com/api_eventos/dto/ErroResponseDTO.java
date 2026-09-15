package com.api_eventos.dto;

public record ErroResponseDTO(
        int status,
        String mensagem
) {
}
