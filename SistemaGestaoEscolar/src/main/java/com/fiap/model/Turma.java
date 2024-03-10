package com.fiap.model;

public enum Turma {

    INGLES1("1 inglês"),
    INGLES2("2 inglês"),
    IMGLES3("3 inglês"),
    ESPANHOL1("1 espanhol"),
    ESPANHOL2("2 espanhol"),
    ESPANHOL3("3 espanhol");

    private String descricao;

    Turma(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
