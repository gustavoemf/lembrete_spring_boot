package com.desafio.lembrete.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "pessoa", schema = "public")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String nome;

    public Pessoa() {}

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
