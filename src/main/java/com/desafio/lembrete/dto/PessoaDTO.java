package com.desafio.lembrete.dto;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PessoaDTO {

    private Long id;
    private String nome;

    public PessoaDTO() {}

    public PessoaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
