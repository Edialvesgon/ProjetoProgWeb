package com.example.demo.application.port.bo;

import java.util.List;

public class TurmaBO {
    private String nome;
    private int periordo;
    private String curso;
    private List<AlunoBO> alunoBOs;

    public List<AlunoBO> getAlunoBOs() {
        return alunoBOs;
    }

    public void setAlunoBOs(List<AlunoBO> alunoBOs) {
        this.alunoBOs = alunoBOs;
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
