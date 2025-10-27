package com.example.demo.adapter.out.persistence.persistenceSQL.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Component;

import com.example.demo.adapter.in.web.dto.AlunoRequest;
import com.example.demo.adapter.out.persistence.dao.TurmaDAO;
import com.example.demo.adapter.out.persistence.entity.AlunoDAOEntity;
import com.example.demo.adapter.out.persistence.entity.TurmaDAOEntity;
//import com.example.demo.adapter.out.persistence.dao.TurmaEntity;
import com.example.demo.adapter.out.persistence.repository.TurmaRepositoyJPA;
import com.example.demo.application.port.bo.AlunoBO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.out.persisteceExecTime.TurmaRepositorie;
import com.example.demo.application.port.out.persistenceSQL.TurmaRepositorieSQL;
import com.example.demo.domain.model.Turma;

@Component
public class TurmaPersistenceMySQL implements TurmaRepositorieSQL {

    private TurmaRepositoyJPA turmaRepositoyJPA;

    public TurmaPersistenceMySQL(TurmaRepositoyJPA turmaRepositoyJPA) {
        this.turmaRepositoyJPA = turmaRepositoyJPA;
    }

    @Override
    public TurmaBO salvar(TurmaBO turma) {
        List<AlunoDAOEntity> entidadeALuno = new ArrayList<>();

        TurmaDAOEntity turmaDAOEntity = new TurmaDAOEntity();
        turmaDAOEntity.setNome(turma.getNome());
        turmaDAOEntity.setCurso(turma.getCurso());
        turmaDAOEntity.setPeriordo(turma.getPeriordo());

        for (AlunoBO alunoBO : turma.getAlunoBOs()) {
            AlunoDAOEntity alunoEntityAtual = new AlunoDAOEntity();
            alunoEntityAtual.setNome(alunoBO.getNome());
            alunoEntityAtual.setTurmaEntity(turmaDAOEntity);
            entidadeALuno.add(alunoEntityAtual);
        }

        turmaDAOEntity.setAlunoEntities(entidadeALuno);

        turmaDAOEntity = turmaRepositoyJPA.save(turmaDAOEntity);

        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setNome(turmaDAOEntity.getNome());
        turmaBO.setPeriordo(turmaDAOEntity.getPeriordo());
        turmaBO.setCurso(turmaDAOEntity.getCurso());

        List<AlunoBO> alunoBOs = new ArrayList<>();
        for (AlunoDAOEntity alunoEntity2 : turmaDAOEntity.getAlunoEntities()) {
            AlunoBO alunoBOAtual = new AlunoBO();
            alunoBOAtual.setNome(alunoEntity2.getNome());
            alunoBOs.add(alunoBOAtual);
        }
        turmaBO.setAlunoBOs(alunoBOs);

        return turmaBO;
    }

    @Override
    public List<TurmaBO> retornarValores() {

        List<TurmaDAOEntity> turmaDAOEntities = turmaRepositoyJPA.findAll();
        List<TurmaBO> turmaBOs = new ArrayList<>();

        for (TurmaDAOEntity turmaDAOEntity : turmaDAOEntities) {

            TurmaBO turmaBO = new TurmaBO();
            turmaBO.setCurso(turmaDAOEntity.getCurso());
            turmaBO.setNome(turmaDAOEntity.getNome());
            turmaBO.setPeriordo(turmaDAOEntity.getPeriordo());

            List<AlunoBO> alunoBOs = new ArrayList<>();

            for (AlunoDAOEntity alunoEntity : turmaDAOEntity.getAlunoEntities()) {
                AlunoBO alunoBO = new AlunoBO();
                alunoBO.setNome(alunoEntity.getNome());
                alunoBOs.add(alunoBO);
            }

            turmaBO.setAlunoBOs(alunoBOs);
            turmaBOs.add(turmaBO);
        }

        return turmaBOs;

    }

    @Override
    public TurmaBO retornarUm(Integer turma) {
        TurmaDAOEntity turmaDAOEntity = turmaRepositoyJPA.findById(turma).orElse(null);

        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setCurso(turmaDAOEntity.getCurso());
        turmaBO.setNome(turmaDAOEntity.getNome());
        turmaBO.setPeriordo(turmaDAOEntity.getPeriordo());

        List<AlunoDAOEntity> alunoDAOEntities = new ArrayList<>();
        for (AlunoDAOEntity alunoDAOEntity : turmaDAOEntity.getAlunoEntities()) {
            AlunoDAOEntity alunoDAOEntityAtual = new AlunoDAOEntity();
            alunoDAOEntityAtual.setNome(alunoDAOEntity.getNome());
            alunoDAOEntityAtual.setTurmaEntity(turmaDAOEntity);
            alunoDAOEntities.add(alunoDAOEntityAtual);
        }

        List<AlunoBO> alunoBOs = new ArrayList<>();
        for (AlunoDAOEntity alunoDAOEntity : alunoDAOEntities) {
            AlunoBO alunoBO = new AlunoBO();
            alunoBO.setNome(alunoDAOEntity.getNome());
            alunoBOs.add(alunoBO);

        }

        turmaBO.setAlunoBOs(alunoBOs);

        return turmaBO;
    }

    @Override
    public TurmaBO retornarNome(String nome) {
        TurmaDAOEntity tuOptional = turmaRepositoyJPA.findByNome(nome);
        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setCurso(tuOptional.getCurso());
        turmaBO.setNome(tuOptional.getNome());
        turmaBO.setPeriordo(tuOptional.getPeriordo());

        List<AlunoBO> alunoBOs = new ArrayList<>();
        for (AlunoDAOEntity alunoDAOEntity : tuOptional.getAlunoEntities()) {
            AlunoBO alunoBO = new AlunoBO();
            alunoBO.setNome(alunoDAOEntity.getNome());
            alunoBOs.add(alunoBO);
        }

        turmaBO.setAlunoBOs(alunoBOs);

        return turmaBO;

    }

    @Override
    public TurmaBO retornarCurso(String curso) {
        final TurmaDAOEntity turma = turmaRepositoyJPA.findByCurso(curso);
        if (turma == null) {
            throw new RuntimeException("Turma nao encontrada");
        }
        final TurmaBO turmaBO = new TurmaBO();
        turmaBO.setNome(turma.getNome());
        turmaBO.setCurso(turma.getCurso());
        turmaBO.setPeriordo(turma.getPeriordo());

        return turmaBO;

    }

    @Override
    public void retornarDeletar(Integer deletar) {
        turmaRepositoyJPA.deleteById(deletar);
    }

    @Override
    public TurmaDAOEntity findByIdEntity(Integer id) {
        return turmaRepositoyJPA.findById(id).orElse(null);

    }

    @Override
    public TurmaDAOEntity saveEntity(TurmaDAOEntity entity) {
        return turmaRepositoyJPA.save(entity);
    }

}
