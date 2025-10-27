package com.example.demo.adapter.out.persistence.persisteceList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.adapter.out.persistence.dao.TurmaDAO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.out.persisteceExecTime.TurmaRepositorie;

@Component
public class TurmaPersistence implements TurmaRepositorie {

    private List<TurmaDAO> turmas = new ArrayList<>();
    // private List<Integer> conta = new ArrayList<>();
    Integer con = 0;

    @Override
    public TurmaBO salvar(TurmaBO turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.setNome(turma.getNome());
        turmaDAO.setCurso(turma.getCurso());
        turmaDAO.setPeriordo(turma.getPeriordo());
        con++;
        turmaDAO.setId(con);
        turmas.add(turmaDAO);

        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setNome(turmaDAO.getNome());
        turmaBO.setCurso(turmaDAO.getCurso());
        turmaBO.setPeriordo(turmaDAO.getPeriordo());

        return turmaBO;
    }

    @Override
    public List<TurmaBO> retornarValores() {
        List<TurmaBO> turmaBOs = new ArrayList<>();

        for (TurmaDAO turmaDAO : turmas) {
            TurmaBO turmaBO = new TurmaBO();
            turmaBO.setNome(turmaDAO.getNome());
            turmaBO.setCurso(turmaDAO.getCurso());
            turmaBO.setPeriordo(turmaDAO.getPeriordo());
            turmaBOs.add(turmaBO);
        }

        return turmaBOs;
        // List<TurmaBO> turmaBOs = new ArrayList<>();
        // turmas.
        // return new ArrayList<>(turmas);
    }

    @Override
    public TurmaBO retornarUm(Integer turma) {

        for (TurmaDAO turma2 : turmas) {
            if (turma.equals(turma2.getPeriordo())) {
                TurmaBO turmaBO = new TurmaBO();
                turmaBO.setCurso(turma2.getCurso());
                turmaBO.setNome(turma2.getNome());
                turmaBO.setPeriordo(turma2.getPeriordo());
                return turmaBO;
            }
        }
        return null;
    }

    @Override
    public TurmaBO retornarNome(String turma) {
        for (TurmaDAO turma2 : turmas) {
            if (turma.equals(turma2.getNome())) {
                TurmaBO turmaBO = new TurmaBO();
                turmaBO.setCurso(turma2.getCurso());
                turmaBO.setNome(turma2.getNome());
                turmaBO.setPeriordo(turma2.getPeriordo());
                return turmaBO;
            }
        }
        return null;
    }

    @Override
    public TurmaBO retornarCurso(String turma) {

        TurmaBO turmaBO = new TurmaBO();
        for (TurmaDAO turmaDAO : turmas) {
            if (turma.equals(turmaDAO.getCurso())) {
                turmaBO.setCurso(turmaDAO.getCurso());
                turmaBO.setNome(turmaDAO.getNome());
                turmaBO.setPeriordo(turmaDAO.getPeriordo());
            }
        }
        return turmaBO;
    }

    @Override
    public void retornarDeletar(Integer deletar) {
        Iterator<TurmaDAO> iterator = turmas.iterator();
        while (iterator.hasNext()) {
            TurmaDAO turmaDAO = iterator.next();
            if (deletar.equals(turmaDAO.getId())) {
                iterator.remove();
                System.out.println("Excluído com sucesso!");
                return;
            }
        }
        System.out.println("ID não encontrado!");
    }

}
