package com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turma_Aluno")
public enum Turma {

    INGLES1("1 inglês"),
    INGLES2("2 inglês"),
    IMGLES3("3 inglês"),
    ESPANHOL1("1 espanhol"),
    ESPANHOL2("2 espanhol"),
    ESPANHOL3("3 espanhol");

    @Id
    private String descricao;

    Turma(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }


    
}
