package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Aluno extends Pessoa {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long rm;
    private double nota;
    private boolean status;
    @ManyToOne
    @JoinColumn(name ="Turma_Aluno")
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
    @Override
    public String getEmail() {
        // TODO Auto-generated method stub
        return super.getEmail();
    }
    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return super.getNome();
    }
    @Override
    public void setEmail(String email) {
        // TODO Auto-generated method stub
        super.setEmail(email);
    }
    @Override
    public void setNome(String nome) {
        // TODO Auto-generated method stub
        super.setNome(nome);
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
    



}
