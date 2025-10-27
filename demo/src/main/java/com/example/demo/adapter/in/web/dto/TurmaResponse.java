package com.example.demo.adapter.in.web.dto;

import java.util.List;

public class TurmaResponse {
    private String nome;
    private int periordo;
    private String curso;
    private List<AlunoResponse> alunoResponses;

    public TurmaResponse(String nome, int periordo, String curso, List<AlunoResponse> alunoResponses) {
        this.nome = nome;
        this.periordo = periordo;
        this.curso = curso;
        this.alunoResponses = alunoResponses;
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

    public List<AlunoResponse> getAlunoResponses() {
        return alunoResponses;
    }

    public void setAlunoResponses(List<AlunoResponse> alunoResponses) {
        this.alunoResponses = alunoResponses;
    }

}
