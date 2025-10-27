package com.example.demo.application.port.in.turmaServiceControllerSQLPort;

import java.util.List;

import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.domain.model.Turma;

public interface TurmaServiceSQLInterface {

    public Turma criarTurma(TurmaBO turma);

    public List<Turma> getAll();

    public Turma retornarUm(Integer turma);

    public Turma retornarNome(String turma);

    public Turma retornarCurso(String curso);

    public void retornarDeletar(Integer deletar);

}
