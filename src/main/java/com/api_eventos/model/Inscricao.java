package com.api_eventos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataInscricao;

    @ManyToOne(cascade = CascadeType.ALL)
    private List<Evento> evento = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private List<Participante> participante = new ArrayList<>();
}

