package com.example.demo.application.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Service;

import com.example.demo.adapter.in.web.dto.AlunoRequest;
import com.example.demo.adapter.in.web.dto.AlunoResponse;
import com.example.demo.adapter.out.persistence.entity.AlunoDAOEntity;
import com.example.demo.adapter.out.persistence.entity.TurmaDAOEntity;
import com.example.demo.application.port.bo.AlunoBO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.in.turmaServiceControllerListPort.TurmaServiceInterface;
import com.example.demo.application.port.out.persisteceExecTime.TurmaRepositorie;
import com.example.demo.application.port.out.persistenceSQL.TurmaRepositorieSQL;
import com.example.demo.domain.model.Turma;

@Service
public class TurmaService implements TurmaServiceInterface {

    private TurmaRepositorie turmaRepositorie;
    private TurmaRepositorieSQL turmaRepositorySQL;

    public TurmaService(TurmaRepositorieSQL turmaRepository, TurmaRepositorie turmaRepositorie) {
        this.turmaRepositorie = turmaRepositorie;
        this.turmaRepositorySQL = turmaRepository;
    }

    @Override
    public TurmaBO criar(Turma turma) {
        List<AlunoBO> alunoBO = new ArrayList<>();
        for (AlunoRequest alunoBO_I : turma.getAlunoRequests()) {
            AlunoBO alunoBO2 = new AlunoBO();
            alunoBO2.setNome(alunoBO_I.getNome());
            alunoBO.add(alunoBO2);
        }

        TurmaBO turmaBO = new TurmaBO();
        turmaBO.setNome(turma.getNome());
        turmaBO.setCurso(turma.getCurso());
        turmaBO.setPeriordo(turma.getPeriordo());
        turmaBO.setAlunoBOs(alunoBO);

        if (turmaBO != null) {
            TurmaBO turmaSalva = turmaRepositorySQL.salvar(turmaBO);

            TurmaBO turmaBORetorno = new TurmaBO();
            turmaBORetorno.setCurso(turmaSalva.getCurso());
            turmaBORetorno.setNome(turmaSalva.getNome());
            turmaBORetorno.setPeriordo(turmaSalva.getPeriordo());

            List<AlunoResponse> alunoResponses = new ArrayList<>();

            for (AlunoBO alunoAtual : turmaSalva.getAlunoBOs()) {
                AlunoResponse alunoResponse = new AlunoResponse();
                alunoResponse.setNome(alunoAtual.getNome());
                alunoResponses.add(alunoResponse);
            }

            turmaBORetorno.setAlunoBOs(alunoBO);
            return turmaBORetorno;
        }

        return turmaBO;
    }

    public List<Turma> getAll() {
        List<TurmaBO> turmaBOs = turmaRepositorySQL.retornarValores();

        List<Turma> turmas = new ArrayList<>();
        for (TurmaBO turmaBO : turmaBOs) {
            Turma turma = new Turma();
            turma.setNome(turmaBO.getNome());
            turma.setCurso(turmaBO.getCurso());
            turma.setPeriordo(turmaBO.getPeriordo());

            List<AlunoBO> alunoBOs = new ArrayList<>();
            for (AlunoBO alunoBOAtual : turmaBO.getAlunoBOs()) {
                AlunoBO alunoBO = new AlunoBO();
                alunoBO.setNome(alunoBOAtual.getNome());
                alunoBOs.add(alunoBO);
            }

            List<AlunoRequest> alunoRequests = new ArrayList<>();
            for (AlunoBO alunoBOConversao : alunoBOs) {
                AlunoRequest alunoRequest = new AlunoRequest();
                alunoRequest.setNome(alunoBOConversao.getNome());
                alunoRequests.add(alunoRequest);
            }

            turma.setAlunoRequests(alunoRequests);

            turmas.add(turma);

        }

        return turmas;

    }

    @Override
    public Turma retornarUm(Integer id) {
        TurmaBO turmaBO = turmaRepositorySQL.retornarUm(id);
        Turma turma = new Turma();
        turma.setCurso(turmaBO.getCurso());
        turma.setNome(turmaBO.getNome());
        turma.setPeriordo(turmaBO.getPeriordo());
        List<AlunoBO> alunoBOs = new ArrayList<>();
        for (AlunoBO alunoRequest : turmaBO.getAlunoBOs()) {
            AlunoBO alunoBO = new AlunoBO();
            alunoBO.setNome(alunoRequest.getNome());
            alunoBOs.add(alunoBO);
        }

        List<AlunoRequest> alunoRequests = new ArrayList<>();
        for (AlunoBO alunoBO : alunoBOs) {
            AlunoRequest alunoRequest = new AlunoRequest();
            alunoRequest.setNome(alunoBO.getNome());
            alunoRequests.add(alunoRequest);
        }

        turma.setAlunoRequests(alunoRequests);
        return turma;
    }

    @Override
    public Turma retornarNome(String nome) {
        TurmaBO turmaBO = turmaRepositorySQL.retornarNome(nome);
        Turma turma2 = new Turma();
        turma2.setCurso(turmaBO.getCurso());
        turma2.setNome(turmaBO.getNome());
        turma2.setPeriordo(turmaBO.getPeriordo());

        List<AlunoRequest> alunoRequests = new ArrayList<>();
        for (AlunoBO alunoBO : turmaBO.getAlunoBOs()) {
            AlunoRequest alunoRequest = new AlunoRequest();
            alunoRequest.setNome(alunoBO.getNome());
            alunoRequests.add(alunoRequest);
        }

        turma2.setAlunoRequests(alunoRequests);

        return turma2;
    }

    @Override
    public Turma retornarCurso(String turma) {
        TurmaBO turmaBO = turmaRepositorySQL.retornarCurso(turma);
        Turma turma2 = new Turma();
        turma2.setCurso(turmaBO.getCurso());
        turma2.setNome(turmaBO.getNome());
        turma2.setPeriordo(turmaBO.getPeriordo());
        return turma2;
    }

    @Override
    public void retornarDeletar(Integer deletar) {
        turmaRepositorySQL.retornarDeletar(deletar);
    }

    public Turma cadastroDeAlunoEmTurmaJaExistente(Integer id, List<AlunoBO> alunoBOs) {
        TurmaDAOEntity turmaExistente = turmaRepositorySQL.findByIdEntity(id);
        if (turmaExistente == null) {
            throw new RuntimeException("Turma com ID " + id + " não encontrada");
        }

        for (AlunoBO alunoBO : alunoBOs) {
            AlunoDAOEntity novoAluno = new AlunoDAOEntity();
            novoAluno.setNome(alunoBO.getNome());
            novoAluno.setTurmaEntity(turmaExistente);
            turmaExistente.getAlunoEntities().add(novoAluno);
        }

        turmaRepositorySQL.saveEntity(turmaExistente);

        Turma turmaRetorno = new Turma();
        turmaRetorno.setNome(turmaExistente.getNome());
        turmaRetorno.setCurso(turmaExistente.getCurso());
        turmaRetorno.setPeriordo(turmaExistente.getPeriordo());
        return turmaRetorno;
    }

    public Turma cadastroDeUmAlunoEmTurma(Integer id, AlunoBO alunoBO) {
        TurmaDAOEntity turmaExistente = turmaRepositorySQL.findByIdEntity(id);
        if (turmaExistente == null) {
            throw new RuntimeException("Turma com ID " + id + " não encontrada");
        }

        AlunoDAOEntity novoAluno = new AlunoDAOEntity();
        novoAluno.setNome(alunoBO.getNome());
        novoAluno.setTurmaEntity(turmaExistente);
        turmaExistente.getAlunoEntities().add(novoAluno);

        turmaRepositorySQL.saveEntity(turmaExistente);

        Turma turmaRetorno = new Turma();
        turmaRetorno.setNome(turmaExistente.getNome());
        turmaRetorno.setCurso(turmaExistente.getCurso());
        turmaRetorno.setPeriordo(turmaExistente.getPeriordo());
        return turmaRetorno;
    }

}

// @Override
// public TurmaBO criarMySQL(TurmaBO turmabo) {
// turmaRepositorySQL.salvar(turmabo);

// return turmabo;
// // TODO Auto-generated method stub
// }

// @Override
// public Turma criarMySQL(Turma turma) {
// TurmaBO turmaBO = new TurmaBO();
// turmaBO.setCurso(turma.getCurso());
// turmaBO.setNome(turma.getNome());
// turmaBO.setPeriordo(turma.getPeriordo());
// TurmaBO turma2 = turmaRepository.salvar(turmaBO);
// Turma turma3 = new Turma();
// turma3.setCurso(turma2.getCurso());
// turma3.setNome(turma2.getNome());
// turma3.setPeriordo(turma2.getPeriordo());
// return turma3;
// }
