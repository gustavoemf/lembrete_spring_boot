package com.desafio.lembrete.services;

import com.desafio.lembrete.entities.Lembrete;
import com.desafio.lembrete.repositories.LembreteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository repository;
    @Transactional
    public void cadastrar(@RequestBody final Lembrete lembrete) {
        if (lembrete.getId() != null) {
            throw new RuntimeException("o campo ID não deve ser inserido");
        }
        this.repository.save(lembrete);
    }

    @Transactional
    public void atualizar(final Long id, Lembrete lembrete) {
        final Lembrete lembreteBanco = this.repository.findById(id).orElse(null);
        if (lembreteBanco != null || !lembreteBanco.getId().equals(lembrete.getId())) {
            throw new RuntimeException("não foi possivel encontrar esse lembrete no banco do sistema");
        }
        this.repository.save(lembrete);
    }

    public List<Lembrete> getLembretesPessoa(String pessoas) {
        return repository.findByPessoas_Nome(pessoas);
    }
}
