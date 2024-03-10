package com.fiap.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.model.Aluno;






@RestController
@RequestMapping("Aluno")
public class AlunoController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Aluno> repository = new ArrayList<>();

    @GetMapping("")
    public List<Aluno> ListaAlunos() {
        return repository;
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno CreateAluno(@RequestBody Aluno aluno){
        log.info("Cadastrando aluno"+ aluno);
        repository.add(aluno);
        return aluno;
    }
    @GetMapping("{rm}")
    public ResponseEntity<Aluno> show(@PathVariable Long Rm){
        log.info("Buscar categoria por Rm {}", Rm);
        var alunoEncontrado = getAlunoById(Rm);
        if(alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(alunoEncontrado.get());
    }
    @DeleteMapping("{rm}")
    public ResponseEntity<Object> destroy(@PathVariable Long rm){
        var alunoEncontrado = getAlunoById(Rm);

        if (alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(alunoEncontrado.get());
        return  ResponseEntity.noContent().build();
    }

  private Optional<Aluno> getAlunoById(Long Rm){
    Var alunoEncontrado = repository.stream().filter(c ->c.id().equals(Rm)).findFirst();

    return alunoEncontrado;
  }
    
    
}
