package com.fiap.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Page<Aluno> findByEmail(String email, Pageable pageable);

    
}
