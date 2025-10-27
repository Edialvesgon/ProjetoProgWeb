package com.example.demo.domain.model;

import java.util.List;

import com.example.demo.adapter.in.web.dto.AlunoRequest;

public class Turma {
    private String nome;
    private int periordo;
    private String curso;
    private List<AlunoRequest> alunoRequests;

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
