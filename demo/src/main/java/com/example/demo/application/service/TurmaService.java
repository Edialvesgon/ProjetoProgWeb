package com.example.demo.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.in.TurmaInServiceI;
import com.example.demo.application.port.out.TurmaRepositorie;
import com.example.demo.application.port.out.TurmaRepositorieSQL;
import com.example.demo.domain.model.Turma;

@Service
public class TurmaService implements TurmaInServiceI {

    private TurmaRepositorie turmaRepositorie;
    private TurmaRepositorieSQL turmaRepository;

    public TurmaService(TurmaRepositorieSQL turmaRepository, TurmaRepositorie turmaRepositorie) {
        this.turmaRepositorie = turmaRepositorie;
        this.turmaRepository = turmaRepository;
    }

    @Override
    public Turma criar(Turma turma) {
        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setNome(turma.getNome());
        turmaBO.setCurso(turma.getCurso());
        turmaBO.setPeriordo(turma.getPeriordo());

        if (turmaBO != null) {
            TurmaBO turmaCriada = turmaRepositorie.salvar(turmaBO);
            Turma turmaDTO = new Turma();
            turmaDTO.setCurso(turmaCriada.getCurso());
            turmaDTO.setNome(turmaCriada.getNome());
            turmaDTO.setPeriordo(turmaCriada.getPeriordo());
            return turmaDTO;
        }

        return turma;
    }

    public List<Turma> getAll() {
        List<TurmaBO> turmaBO = turmaRepositorie.retornarValores();
        List<Turma> turma = new ArrayList<>();
        for (TurmaBO turmabo2 : turmaBO) {
            Turma turmas = new Turma();
            turmas.setNome(turmabo2.getNome());
            turmas.setCurso(turmabo2.getCurso());
            turmas.setPeriordo(turmabo2.getPeriordo());
            turma.add(turmas);
        }
        return turma;

    }

    @Override
    public Turma retornarUm(Integer turma) {
        TurmaBO turmaBO = turmaRepositorie.retornarUm(turma);
        Turma turma2 = new Turma();
        turma2.setCurso(turmaBO.getCurso());
        turma2.setNome(turmaBO.getNome());
        turma2.setPeriordo(turmaBO.getPeriordo());
        return turma2;
    }

    @Override
    public Turma retornarNome(String nome) {
        TurmaBO turmaBO = turmaRepositorie.retornarNome(nome);
        Turma turma2 = new Turma();
        turma2.setCurso(turmaBO.getCurso());
        turma2.setNome(turmaBO.getNome());
        turma2.setPeriordo(turmaBO.getPeriordo());
        return turma2;
    }

    @Override
    public Turma retornarCurso(String turma) {
        TurmaBO turmaBO = turmaRepositorie.retornarCurso(turma);
        Turma turma2 = new Turma();
        turma2.setCurso(turmaBO.getCurso());
        turma2.setNome(turmaBO.getNome());
        turma2.setPeriordo(turmaBO.getPeriordo());
        return turma2;
    }

    @Override
    public void retornarDeletar(Integer deletar) {
        turmaRepositorie.retornarDeletar(deletar);
    }

    @Override
    public Turma criarMySQL(Turma turma) {
        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setCurso(turma.getCurso());
        turmaBO.setNome(turma.getNome());
        turmaBO.setPeriordo(turma.getPeriordo());
        TurmaBO turma2 = turmaRepository.salvar(turmaBO);
        Turma turma3 = new Turma();
        turma3.setCurso(turma2.getCurso());
        turma3.setNome(turma2.getNome());
        turma3.setPeriordo(turma2.getPeriordo());
        return turma3;
    }

}
