package com.desafio.lembrete.dto;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Pessoa {

    private Long id;
    private String nome;

    public Pessoa() {}

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
