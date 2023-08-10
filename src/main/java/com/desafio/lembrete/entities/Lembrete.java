package com.desafio.lembrete.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "lembrete", schema = "public")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDateTime data;
    @ManyToMany
    @JoinTable(
            name = "lembretes_pessoas",
            joinColumns = @JoinColumn(name = "lembrete_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> pessoas = new ArrayList<>();

    public Lembrete() {}

    public Lembrete(Long id, String nome, LocalDateTime data, List<Pessoa> pessoas) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.pessoas = pessoas;
    }
}
