package com.api_eventos.repository;

import com.api_eventos.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    boolean existsByEmail(String email);

}
