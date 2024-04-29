package com.fiap.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.model.Aluno;
import com.fiap.repository.AlunoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public void run(String... args) throws Exception {
        alunoRepository.saveAll(
            List.of(
                Aluno.builder().rm(1L).nome("gabriel").email("alef@nsei.com").status(true).build(),
                Aluno.builder().rm(1L).nome("gabriel").email("alef@nsei.com").status(true).build()
            )
        );


    }
}
