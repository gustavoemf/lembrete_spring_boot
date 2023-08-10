package com.desafio.lembrete.repositories;

import com.desafio.lembrete.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}