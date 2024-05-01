package com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.model.Turma;
import com.fiap.repository.TurmaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turma")

public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;


    @GetMapping
    public List<Turma> index() {
        return turmaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turma CreateTurma(@RequestBody @Valid Turma turma){    
    return turmaRepository.save(turma);
    }

    @GetMapping("{id}")
    public ResponseEntity<Turma> show(@PathVariable Long id){
       
     
     return turmaRepository
     .findById(id)
     .map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        
        VerificarSeExisteTurma(id);

        turmaRepository.deleteById(id);
    }

    @PutMapping("{id}")
     public Turma update(@PathVariable Long id, @RequestBody Turma turma){
       
         VerificarSeExisteTurma(id);

         turma.setId(id);
        return turmaRepository.save(turma);
     }

    private void VerificarSeExisteTurma(Long id) {
        turmaRepository.findById(id)
        .orElseThrow(()-> new ResponseStatusException
        (HttpStatus.NOT_FOUND,
     "Não existe turma com esse id"));
    }
}
