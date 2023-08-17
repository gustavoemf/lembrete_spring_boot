package com.desafio.lembrete.controllers;

import com.desafio.lembrete.dto.PessoaDTO;
import com.desafio.lembrete.entities.Pessoa;
import com.desafio.lembrete.repositories.PessoaRepository;
import com.desafio.lembrete.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        try {
            return ResponseEntity.ok(this.repository.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrar(@RequestBody final PessoaDTO pessoaDTO){
        try{
            return ResponseEntity.ok(this.service.cadastrar(pessoaDTO));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <?> atualizar(@PathVariable("id") final Long id, @RequestBody final Pessoa pessoa){
        try{
            this.service.atualizar(id, pessoa);
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Erro " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Pessoa atualizada com sucesso");
    }

    @DeleteMapping
    public ResponseEntity <?> deletar(@RequestParam("id") final Long id){
        final Pessoa pessoaBanco = this.repository.findById(id).orElse(null);
        try{
            this.repository.delete(pessoaBanco);
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Erro" + e.getCause().getCause().getMessage());
        }
        return ResponseEntity.ok("Pessoa deletada com sucesso");
    }
}
