package com.example.demo.adapter.in.web.dto;

import java.util.List;

public class TurmaRequest {
    private String nome;
    private int periordo;
    private String curso;
    private List<AlunoRequest> alunoRequests;

    public TurmaRequest(String nome, int periordo, String curso) {
        this.nome = nome;
        this.periordo = periordo;
        this.curso = curso;
    }

    public List<AlunoRequest> getAlunoRequests() {
        return alunoRequests;
    }

    public void setAlunoRequests(List<AlunoRequest> alunoRequests) {
        this.alunoRequests = alunoRequests;
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
