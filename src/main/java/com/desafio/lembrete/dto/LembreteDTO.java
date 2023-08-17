package com.desafio.lembrete.dto;

import com.desafio.lembrete.entities.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class LembreteDTO {
    private Long id;
    private String nome;
    private LocalDateTime data;
    private List<Pessoa> pessoas = new ArrayList<>();

    public LembreteDTO() {}

    public LembreteDTO(Long id, String nome, LocalDateTime data, List<Pessoa> pessoas) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.pessoas = pessoas;
    }
}
