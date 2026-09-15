package com.api_eventos.exception;

import com.api_eventos.dto.ErroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErroResponseDTO> handleJaCadastrado(EmailJaCadastradoException ex) {
        ErroResponseDTO corpo = new ErroResponseDTO(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(corpo);
    }

    @ExceptionHandler(InscricaoNaoDisponivelException.class)
    public ResponseEntity<ErroResponseDTO> handleNaoDisponivel(InscricaoNaoDisponivelException ex) {
        ErroResponseDTO corpo = new ErroResponseDTO(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(corpo);
    }

    @ExceptionHandler(EventoLotadoException.class)
    public ResponseEntity<ErroResponseDTO> handleLotado(EventoLotadoException ex) {
        ErroResponseDTO corpo = new ErroResponseDTO(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(corpo);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponseDTO> handleNotFound(RecursoNaoEncontradoException ex) {
        ErroResponseDTO corpo = new ErroResponseDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corpo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> errosDeValidacao(MethodArgumentNotValidException erro){
        Map<String, String> erros = new HashMap<>();
        erro.getBindingResult().getAllErrors().forEach(error -> {
            String campoQueDeuErro = ((FieldError)error).getField();
            String mensagemDeErro = error.getDefaultMessage();

            erros.put(campoQueDeuErro, mensagemDeErro);
        });

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}
