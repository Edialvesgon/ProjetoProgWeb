// package com.example.demo.adapter.in.web.controllerList;

// import java.net.URI;
// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.adapter.in.web.dto.TurmaRequest;
// import com.example.demo.adapter.in.web.dto.TurmaResponse;
// import com.example.demo.application.port.bo.TurmaBO;
// import
// com.example.demo.application.port.in.turmaServiceControllerListPort.TurmaServiceInterface;
// import com.example.demo.domain.model.Turma;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

// @RestController
// @RequestMapping("/turma")
// @CrossOrigin(origins = "*")
// // @CrossOrigin(origins = "https://e7ccad58de5f.ngrok-free.app")
// // @CrossOrigin(origins = "http://localhost:5173")
// public class TurmasControllerList {

// TurmaServiceInterface turmaInterface;

// public TurmasControllerList(TurmaServiceInterface turmaInterface) {
// this.turmaInterface = turmaInterface;
// }

// private TurmaResponse toResponse(Turma T) {
// return new TurmaResponse(T.getNome(), T.getPeriordo(), T.getCurso());
// }

// @PostMapping
// public ResponseEntity<TurmaResponse> criar(@RequestBody TurmaRequest
// turmaResponse) {
// Turma turma = new Turma();
// turma.setNome(turmaResponse.getNome());
// turma.setCurso(turmaResponse.getCurso());
// turma.setPeriordo(turmaResponse.getPeriordo());
// Turma salva = turmaInterface.criar(turma);
// return ResponseEntity.ok(toResponse(salva));
// // return
// //
// ResponseEntity.created(URI.create("/turma"+salva.getNome())).body(toResponse(salva));
// }

// @GetMapping("/all")
// public ResponseEntity<List<Turma>> getAll() {
// List<Turma> turmas = turmaInterface.getAll();
// return ResponseEntity.ok(turmas);
// }

// @GetMapping("periodo/{periordo}")
// public ResponseEntity<TurmaResponse> retornarUm(@PathVariable("periordo") int
// idperiodo) {
// Turma turma = turmaInterface.retornarUm(idperiodo);

// if (turma == null) {
// return ResponseEntity.notFound().build();
// }

// TurmaResponse turmaResponse = new TurmaResponse(
// turma.getNome(),
// turma.getPeriordo(),
// turma.getCurso());

// return ResponseEntity.ok(turmaResponse);
// }

// @GetMapping("/nome/{nome}")
// public ResponseEntity<TurmaResponse> retornarNome(@PathVariable("nome")
// String nome) {
// Turma turma = turmaInterface.retornarNome(nome);

// if (turma == null) {
// return ResponseEntity.notFound().build();
// }

// TurmaResponse turmaResponse = new TurmaResponse(
// turma.getNome(),
// turma.getPeriordo(),
// turma.getCurso());

// return ResponseEntity.ok(turmaResponse);
// }

// @GetMapping("/curso/{curso}")
// public ResponseEntity<TurmaResponse> retornarCurso(@PathVariable("curso")
// String curso) {
// Turma turma = turmaInterface.retornarCurso(curso);
// TurmaResponse turmaResponse = new TurmaResponse(turma.getNome(),
// turma.getPeriordo(), turma.getCurso());

// return ResponseEntity.ok(turmaResponse);
// }

// @DeleteMapping("deletar/{id}")
// public ResponseEntity<String> deletarId(@PathVariable("id") Integer id) {
// turmaInterface.retornarDeletar(id);
// return ResponseEntity.ok("Cliente com ID " + id + " foi deletado");

// }

// // @PostMapping("/sql")
// // public ResponseEntity<TurmaResponse> criarSQL(@RequestBody TurmaRequest
// // turmaResponse) {
// // TurmaBO turma = new TurmaBO();
// // turma.setNome(turmaResponse.getNome());
// // turma.setCurso(turmaResponse.getCurso());
// // turma.setPeriordo(turmaResponse.getPeriordo());
// // TurmaBO salva = turmaInterface.criarMySQL(turma);

// // TurmaResponse turmaResponse2 = new TurmaResponse(salva.getNome(),
// // salva.getPeriordo(), salva.getCurso());

// // return ResponseEntity.ok(turmaResponse2);

// // }

// }
