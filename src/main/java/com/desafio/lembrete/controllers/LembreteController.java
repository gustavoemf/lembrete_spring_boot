package com.desafio.lembrete.controllers;

import com.desafio.lembrete.repositories.LembreteRepository;
import com.desafio.lembrete.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lembrete")
public class LembreteController {
    @Autowired
    private LembreteRepository repository;
    @Autowired
    private LembreteService service;
}
