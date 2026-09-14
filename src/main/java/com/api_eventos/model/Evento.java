package com.api_eventos.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private Integer capacidadeMaxima;

    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes = new ArrayList<>();
}
