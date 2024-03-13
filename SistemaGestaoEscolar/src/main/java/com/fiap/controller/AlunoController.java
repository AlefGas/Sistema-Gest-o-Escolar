package com.fiap.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
     return alunoRepository.findById(Rm).map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());

     //   var alunoEncontrado = alunoRepository.findById(Rm);
     // if(alunoEncontrado.isEmpty())
     //       return ResponseEntity.notFound().build();
     //   return ResponseEntity.ok(alunoEncontrado.get());
    }

    @DeleteMapping("{rm}")
    public ResponseEntity<Object> destroy(@PathVariable Long rm){
        var alunoEncontrado = alunoRepository.findById(rm);


        alunoRepository.findById(rm).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe aluno com rm informado"));


        alunoRepository.deleteById(rm);
        return ResponseEntity.noContent().build();
        //if (alunoEncontrado.isEmpty())
          //  return ResponseEntity.notFound().build();

        //alunoRepository.delete(alunoEncontrado.get());
       // return  ResponseEntity.noContent().build();
    }
    /**
     * @param rm
     * @param aluno
     * @return
     */
    @PutMapping("{id}")
     public ResponseEntity<Aluno> update(@PathVariable Long rm, @RequestBody Aluno aluno){
        log.info("atualizando categoria com id {} para {}", rm, aluno);
         VerificarSeExisteAluno(rm);

         aluno.setRm(rm);
        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
     }
     
    private void VerificarSeExisteAluno(Long rm) {
        alunoRepository.findById(rm).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe aluno com rm "));
    }

         
       
        








       //var categoriaEncontrada = getCategoriaById(id);

        //if (categoriaEncontrada.isEmpty())
          // return ResponseEntity.notFound().build();

    //     // criar uma nova categoria com os novos dados
    //     var categoriaAntiga = categoriaEncontrada.get();
    //     var categoriaNova = new Categoria(id, categoria.nome(), categoria.icone());
        
    //     // apagar a categoria antiga
    //     repository.remove(categoriaAntiga);

    //     // add a categoria nova
    //     repository.add(categoriaNova);

    //     return ResponseEntity.ok(categoriaNova);
    // }


  public Optional<Aluno> getAlunoById(Long rm){
    var alunoEncontrado = repository.stream().filter(c ->c.getRm().equals(rm)).findFirst();

    return alunoEncontrado;
  }


    
    
}
