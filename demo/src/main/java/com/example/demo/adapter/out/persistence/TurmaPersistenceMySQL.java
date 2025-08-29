package com.example.demo.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.adapter.out.dao.TurmaDAO;
import com.example.demo.adapter.out.dao.TurmaDAOEntity;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.out.TurmaRepositorie;
import com.example.demo.application.port.out.TurmaRepositorieSQL;
import com.example.demo.domain.model.Turma;

@Component
public class TurmaPersistenceMySQL implements TurmaRepositorieSQL {

    private TurmaRepositoyJPA turmaRepositoyJPA;

    public TurmaPersistenceMySQL(TurmaRepositoyJPA turmaRepositoyJPA) {
        this.turmaRepositoyJPA = turmaRepositoyJPA;
    }

    @Override
    public TurmaBO salvar(TurmaBO turma) {
        TurmaDAOEntity turmaDAO = new TurmaDAOEntity();
        turmaDAO.setNome(turma.getNome());
        turmaDAO.setCurso(turma.getCurso());
        turmaDAO.setPeriordo(turma.getPeriordo());
        // turmaDAO.setId(1);
        turmaDAO = turmaRepositoyJPA.save(turmaDAO);

        TurmaBO turmaBO = new TurmaBO();
        // turmaBO.setId(turmaDAO.getId());
        turmaBO.setNome(turmaDAO.getNome());
        turmaBO.setPeriordo(turmaDAO.getPeriordo());
        turmaBO.setCurso(turmaDAO.getCurso());

        return turmaBO;
    }

}
