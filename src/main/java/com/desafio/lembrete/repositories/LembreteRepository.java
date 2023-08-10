package com.desafio.lembrete.repositories;

import com.desafio.lembrete.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByPessoas_Nome(String pessoas);
}