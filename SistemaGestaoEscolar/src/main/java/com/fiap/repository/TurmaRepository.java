package com.fiap.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    // Page<Aluno> findByNome(String nome, Pageable pageable);

    // Page<Turma> findByAlunosNome(String nome, Pageable pageable);


    
}
