package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Aluno extends Pessoa {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long rm;
    private double nota;
    private boolean status;
    private Turma turmaAluno;
    private double media;
    private Semestre semestreAluno;

    
    //construtor da Classe Aluno que extends da classe abstrata Pessoa 
    public Aluno(String nome, String email, Long rm, double nota, boolean status, Turma turmaAluno,
            Semestre semestreAluno) {
        super(nome, email);
        this.rm = rm;
        this.nota = nota;
        this.status = status;
        this.turmaAluno = turmaAluno;
        this.semestreAluno = semestreAluno;
    }
    public Long getRm() {
        return rm;
    }
    public void setRm(Long rm) {
        this.rm = rm;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Turma getTurmaAluno() {
        return turmaAluno;
    }
    public void setTurmaAluno(Turma turmaAluno) {
        this.turmaAluno = turmaAluno;
    }
    public double getMedia() {
        return media;
    }
    public void setMedia(double media) {
        this.media = media;
    }
    public Semestre getSemestreAluno() {
        return semestreAluno;
    }
    public void setSemestreAluno(Semestre semestreAluno) {
        this.semestreAluno = semestreAluno;
    }

    




}
