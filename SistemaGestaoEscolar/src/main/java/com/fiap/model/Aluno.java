package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Data
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
    @ManyToOne
    @JoinColumn(name ="Turma_Aluno")
    private Turma turmaAluno;
    @PositiveOrZero
    private double media;
    @JoinColumn(name ="semestre_Aluno")
    private Semestre semestreAluno;

    
   

    
    



}
