package com.fiap.model;

public abstract class Pessoa {

    public String Nome;
    public String Email;

    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Pessoa(String nome, String email) {
        Nome = nome;
        Email = email;
    }
    
    

}
