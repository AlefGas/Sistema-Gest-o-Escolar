package com.fiap.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fiap.repository.AlunoRepository;
import com.fiap.repository.TurmaRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    TurmaRepository turmaRepository;

    @Override
    public void run(String... args) throws Exception {
        alunoRepository.saveAll(
            List.of(
                
            )
        );


    }
}
