package com.fiap.controller;

import static org.springframework.http.HttpStatus.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.component.NullAwareBeanUtilsBean;
import com.fiap.model.Aluno;
import com.fiap.repository.AlunoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
// @CacheConfig(cacheNames = "Aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    NullAwareBeanUtilsBean beanUtilsBean;
    

    @GetMapping
    // @Cacheable("Alunos")
    public List<Aluno> index() {
        return alunoRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    // @CacheEvict(allEntries = true)
    public Aluno CreateAluno(@RequestBody @Valid Aluno aluno){    
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
    @ResponseStatus(NO_CONTENT)
    // @CacheEvict(allEntries = true)
    public void destroy(@PathVariable Long rm){
        
        VerificarSeExisteAluno(rm);

        alunoRepository.deleteById(rm);
        
        
    }

    
    @PatchMapping("/nota/{rm}")
	public Aluno patchUpdate(@RequestBody Aluno aluno, @PathVariable Long rm) throws InvocationTargetException, IllegalAccessException {
		Aluno alunoEncontrado =  RetornaSeExisteAluno(rm);

		beanUtilsBean.copyProperties(alunoEncontrado, aluno);
        System.out.println(alunoEncontrado);

		return alunoRepository.save(alunoEncontrado);
	}


    
    @PutMapping("{rm}")
    // @CacheEvict(allEntries = true)
     public Aluno update(@PathVariable Long rm, @RequestBody Aluno aluno){
       
         VerificarSeExisteAluno(rm);

         aluno.setRm(rm);
        return alunoRepository.save(aluno);
     }
     
    private void VerificarSeExisteAluno(Long rm) {
        alunoRepository
        .findById(rm)
        .orElseThrow(()-> new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Não existe aluno com este rm "));
    }

    private Aluno RetornaSeExisteAluno(Long rm) {
        return alunoRepository
        .findById(rm)
        .orElseThrow(()-> new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Não existe aluno com este rm "));
    }

    
}
