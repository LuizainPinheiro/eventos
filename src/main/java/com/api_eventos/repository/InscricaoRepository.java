package com.api_eventos.repository;

import com.api_eventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    List<Inscricao> findByEventoId(Long eventoId);

    boolean existsByDataInscricaoAndParticipanteIdAndEventoId(
            LocalDate dataInscricao,
            Long participanteId,
            Long eventoId
    );
}