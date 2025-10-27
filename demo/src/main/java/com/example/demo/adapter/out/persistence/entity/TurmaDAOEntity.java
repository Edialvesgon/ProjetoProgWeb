package com.example.demo.adapter.out.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turmas")
public class TurmaDAOEntity {
    @Id
    @Column(name = "id_turma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private int periordo;
    private String curso;

    @OneToMany(mappedBy = "turmaDAOEntity", cascade = CascadeType.ALL)
    private List<AlunoDAOEntity> alunoEntities;

    public List<AlunoDAOEntity> getAlunoEntities() {
        return alunoEntities;
    }

    public void setAlunoEntities(List<AlunoDAOEntity> alunoEntities) {
        this.alunoEntities = alunoEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
