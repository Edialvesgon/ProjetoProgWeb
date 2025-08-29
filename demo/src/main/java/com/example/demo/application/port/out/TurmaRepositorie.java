package com.example.demo.application.port.out;

import java.util.List;

import com.example.demo.adapter.out.dao.TurmaDAO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.domain.model.Turma;

public interface TurmaRepositorie {
    public TurmaBO salvar(TurmaBO turma);
    public List<TurmaBO> retornarValores();
    public TurmaBO retornarUm(Integer turma);
    public TurmaBO retornarNome(String nome);
    public TurmaBO retornarCurso(String curso);
    public void retornarDeletar(Integer deletar);
}
