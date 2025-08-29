package com.example.demo.adapter.out.dao;

public class TurmaDAO {
    private Integer id;
    private String nome;
    private int periordo;
    private String curso;
    
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
}
