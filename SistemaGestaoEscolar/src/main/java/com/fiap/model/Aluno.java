package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long rm;
    
    @NotBlank(message = "{aluno.nome.notblank}")
    private String nome;
    @NotBlank(message = "{aluno.email.notblank}")
    private String email;
    @PositiveOrZero
    private Double nota1;
    @PositiveOrZero
    private Double nota2;
    @PositiveOrZero
    private Double nota3;
    private boolean status;
    @PositiveOrZero
    private Double media;
    @Enumerated(EnumType.STRING)
    private Semestre semestreAluno;



}
