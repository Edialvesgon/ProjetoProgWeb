package com.example.demo.application.port.out.persistenceSQL;

import java.util.List;

import com.example.demo.adapter.in.web.dto.AlunoRequest;
import com.example.demo.adapter.out.persistence.entity.TurmaDAOEntity;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.domain.model.Turma;

public interface TurmaRepositorieSQL {
    TurmaBO salvar(TurmaBO turma);

    public List<TurmaBO> retornarValores();

    public TurmaBO retornarUm(Integer turma);

    public TurmaBO retornarNome(String nome);

    public TurmaBO retornarCurso(String curso);

    public void retornarDeletar(Integer deletar);

    TurmaDAOEntity findByIdEntity(Integer id);

    TurmaDAOEntity saveEntity(TurmaDAOEntity entity);
}
