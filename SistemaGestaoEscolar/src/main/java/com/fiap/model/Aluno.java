package com.fiap.model;

public class Aluno extends Pessoa {

    private Long rm;
    private double nota;
    private boolean status;
    private Enum turma;
    private double media;
    private Enum Semestre;

    public Long getRm (){
        return rm;
    }
    public double getNota(){
        return nota;
    }
    public boolean getStatus(){
        return status;
    }
    public Enum getTurma(){
        return turma;
    }




}
