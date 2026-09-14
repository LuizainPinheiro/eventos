package com.api_eventos.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "inscricao")
    private Inscricao inscricao;
}
