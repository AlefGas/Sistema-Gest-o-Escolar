package com.fiap.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.fiap.repository.AlunoRepository;







@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    Logger log = LoggerFactory.getLogger(getClass());
    List<Aluno> repository = new ArrayList<>();

    @GetMapping
    public List<Aluno> index() {
        return alunoRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno CreateAluno(@RequestBody Aluno aluno){
        log.info("Cadastrando aluno",  aluno);
        alunoRepository.save(aluno);
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
        var alunoEncontrado = getAlunoById(rm);

        if (alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(alunoEncontrado.get());
        return  ResponseEntity.noContent().build();
    }

  public Optional<Aluno> getAlunoById(Long rm){
    var alunoEncontrado = repository.stream().filter(c ->c.getRm().equals(rm)).findFirst();

    return alunoEncontrado;
  }

    
    
}
