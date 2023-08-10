package com.desafio.lembrete.repositories;

import com.desafio.lembrete.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {}