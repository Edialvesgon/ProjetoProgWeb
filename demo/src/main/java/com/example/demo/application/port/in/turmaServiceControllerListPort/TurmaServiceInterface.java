package com.example.demo.application.port.in.turmaServiceControllerListPort;

import java.lang.invoke.StringConcatException;
import java.util.List;

import com.example.demo.application.port.bo.AlunoBO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.domain.model.Turma;

public interface TurmaServiceInterface {
    public TurmaBO criar(Turma turma);

    // public TurmaBO criarMySQL(TurmaBO turma);

    public List<Turma> getAll();

    public Turma retornarUm(Integer turma);

    public Turma retornarNome(String turma);

    public Turma retornarCurso(String curso);

    public void retornarDeletar(Integer deletar);

    public Turma cadastroDeAlunoEmTurmaJaExistente(Integer id, List<AlunoBO> alunoBO);

    public Turma cadastroDeUmAlunoEmTurma(Integer id, AlunoBO alunoBO);
}
