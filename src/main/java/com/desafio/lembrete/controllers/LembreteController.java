package com.desafio.lembrete.controllers;

import com.desafio.lembrete.entities.Lembrete;
import com.desafio.lembrete.repositories.LembreteRepository;
import com.desafio.lembrete.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {
    @Autowired
    private LembreteRepository repository;
    @Autowired
    private LembreteService service;

    @GetMapping
    public ResponseEntity<?> buscar(@RequestParam("nome") String pessoas) {
        try {
            List<Lembrete> lembretes = service.getLembretesPessoa(pessoas);
            return ResponseEntity.ok(lembretes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro " + e.getMessage());
            //return ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Lembrete lembrete) {
        try {
            service.cadastrar(lembrete);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestParam("id") final Long id, @RequestBody final Lembrete lembrete) {
        try {
            this.service.atualizar(id, lembrete);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Erro " + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Erro " + e.getMessage());
        }
        return ResponseEntity.ok("Registro atualizado com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<?> deletar(@RequestParam("id") final Long id) {
        final Lembrete lembreteBanco = this.repository.findById(id).orElse(null);
        try {
            this.repository.delete(lembreteBanco);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Erro" + e.getCause().getCause().getMessage());
        }
        return ResponseEntity.ok("Lembrete deletado com sucesso");
    }
}
