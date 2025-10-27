package com.example.demo.adapter.in.web.controllerSQL;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adapter.in.web.dto.AlunoRequest;
import com.example.demo.adapter.in.web.dto.AlunoResponse;
import com.example.demo.adapter.in.web.dto.TurmaRequest;
import com.example.demo.adapter.in.web.dto.TurmaResponse;
import com.example.demo.application.port.bo.AlunoBO;
import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.application.port.in.turmaServiceControllerListPort.TurmaServiceInterface;
import com.example.demo.application.port.in.turmaServiceControllerSQLPort.TurmaServiceSQLInterface;
import com.example.demo.domain.model.Turma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/turmas")
public class TurmasControllerSql {

    private TurmaServiceInterface turmaServiceSQLInterface;

    public TurmasControllerSql(TurmaServiceInterface turmaServiceSQLInterface) {
        this.turmaServiceSQLInterface = turmaServiceSQLInterface;
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> criar(@RequestBody TurmaRequest turmaResponse) {

        Turma turma = new Turma();
        turma.setNome(turmaResponse.getNome());
        turma.setCurso(turmaResponse.getCurso());
        turma.setPeriordo(turmaResponse.getPeriordo());
        turma.setAlunoRequests(turmaResponse.getAlunoRequests());

        TurmaBO salva = turmaServiceSQLInterface.criar(turma);

        List<AlunoResponse> alunoResponse = new ArrayList<>();
        for (AlunoBO alunoBO : salva.getAlunoBOs()) {
            AlunoResponse alunoCriado = new AlunoResponse();
            alunoCriado.setNome(alunoBO.getNome());
            alunoResponse.add(alunoCriado);
        }

        TurmaResponse turmaResponse2 = new TurmaResponse(salva.getNome(), salva.getPeriordo(), salva.getCurso(),
                alunoResponse);

        return ResponseEntity.ok(turmaResponse2);
        // return
        // ResponseEntity.created(URI.create("/turma"+salva.getNome())).body(toResponse(salva));
    }

    @PostMapping("/{idTurma}")
    public ResponseEntity<TurmaResponse> inserirListaDeAlunosNaTurma(@RequestBody List<AlunoRequest> alunoRequest,
            @PathVariable Integer idTurma) {

        List<AlunoBO> alunoBOs = new ArrayList<>();
        for (AlunoRequest alunoRequestAtual : alunoRequest) {
            AlunoBO alunoBOAtual = new AlunoBO();
            alunoBOAtual.setNome(alunoRequestAtual.getNome());
            alunoBOs.add(alunoBOAtual);
        }

        turmaServiceSQLInterface.cadastroDeAlunoEmTurmaJaExistente(idTurma, alunoBOs);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{idTurma}/aluno")
    public ResponseEntity<TurmaResponse> inserirAlunoNaTurma(@RequestBody AlunoRequest alunoRequest,
            @PathVariable Integer idTurma) {

        AlunoBO alunoBOAtual = new AlunoBO();
        alunoBOAtual.setNome(alunoRequest.getNome());

        turmaServiceSQLInterface.cadastroDeUmAlunoEmTurma(idTurma, alunoBOAtual);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Turma>> getAll() {
        List<Turma> turmas = turmaServiceSQLInterface.getAll();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscaPorUmALuno(@PathVariable Integer id) {
        Turma turmas = turmaServiceSQLInterface.retornarUm(id);
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Turma> buscaPorNome(@PathVariable String nome) {
        Turma turmas = turmaServiceSQLInterface.retornarNome(nome);
        return ResponseEntity.ok(turmas);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarId(@PathVariable("id") Integer id) {
        turmaServiceSQLInterface.retornarDeletar(id);
        return ResponseEntity.ok("Cliente com ID " + id + " foi deletado");

    }

}
