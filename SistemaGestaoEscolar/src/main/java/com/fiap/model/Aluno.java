package com.fiap.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder

public class Aluno {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long rm;
    
    @NotBlank(message = "{aluno.nome.notblank}")
    private String nome;
    @NotBlank(message = "{aluno.email.notblank}")
    private String email;
    @PositiveOrZero
    private double nota;

    private boolean status;
    
    @Enumerated(EnumType.STRING)
    private Turma turmaAluno;
    @PositiveOrZero
    private double media;
    @JoinColumn(name ="semestre_Aluno")
    @Enumerated(EnumType.STRING)
    @Embedded
    private Semestre semestreAluno;



}
