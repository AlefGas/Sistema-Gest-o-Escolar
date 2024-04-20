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

import com.fiap.model.Aluno;
import com.fiap.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    

    @GetMapping
    public List<Aluno> index() {
        return alunoRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno CreateAluno(@RequestBody Aluno aluno){    
    return alunoRepository.save(aluno);
     
    }
    @GetMapping("{Rm}")
    public ResponseEntity<Aluno> show(@PathVariable Long Rm){
       
     
     return alunoRepository
     .findById(Rm)
     .map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{rm}")
    public ResponseEntity<Object> destroy(@PathVariable Long rm){
        


        alunoRepository.findById(rm).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe aluno com rm informado"));


        alunoRepository.deleteById(rm);
        return ResponseEntity.noContent().build();
        
    }
  
    
    @PutMapping("{rm}")
     public ResponseEntity<Aluno> update(@PathVariable Long rm, @RequestBody Aluno aluno){
       
         VerificarSeExisteAluno(rm);

         aluno.setRm(rm);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
     }
     
    private void VerificarSeExisteAluno(Long rm) {
        alunoRepository
        .findById(rm)
        .orElseThrow(()-> new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Não existe aluno com rm "));
    }

    
}
