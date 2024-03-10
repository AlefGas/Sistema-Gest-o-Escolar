package com.fiap.model;

public enum Semestre {

    Semestre1("1° Semestre"),
    Semestre2("2° Semestre");

    private String DescricaoSemestre;


    Semestre(String descricaoSemestre){
        this.DescricaoSemestre = descricaoSemestre;

    }
    public String getDescricao(){
        return DescricaoSemestre;
    }

}
