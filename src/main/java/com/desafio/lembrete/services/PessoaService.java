package com.desafio.lembrete.services;

import com.desafio.lembrete.dto.PessoaDTO;
import com.desafio.lembrete.entities.Pessoa;
import com.desafio.lembrete.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Transactional
    public Pessoa cadastrar(@RequestBody final PessoaDTO pessoaDTO) {
        if (pessoaDTO.getId() != null) {
            throw new RuntimeException("o campo ID não deve ser inserido");
        }
        Pessoa pessoab = toPessoaDTO(pessoaDTO);
        return this.repository.save(pessoab);
    }

    public Pessoa toPessoaDTO(PessoaDTO pessoaDTO){
        Pessoa pessoaTemp = new Pessoa();
        pessoaTemp.setNome(pessoaDTO.getNome());
        return pessoaTemp;
    }

    @Transactional
    public void atualizar(final Long id, Pessoa pessoa) {
        final Pessoa pessoaBanco = this.repository.findById(id).orElse(null);
        if (pessoaBanco != null || !pessoaBanco.getId().equals(pessoa.getId())) {
            throw new RuntimeException("não foi possivel encontrar esse nome no banco do sistema");
        }
        this.repository.save(pessoa);
    }
}
