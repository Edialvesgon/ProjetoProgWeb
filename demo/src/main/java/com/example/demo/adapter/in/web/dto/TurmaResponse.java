package com.example.demo.adapter.in.web.dto;

public class TurmaResponse {
    private String nome;
    private int periordo;
    private String curso;

    public TurmaResponse(String nome, int periordo, String curso) {
        this.nome = nome;
        this.periordo = periordo;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriordo() {
        return periordo;
    }

    public void setPeriordo(int periordo) {
        this.periordo = periordo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    

    
}
