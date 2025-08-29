package com.example.demo.application.port.out;

import com.example.demo.application.port.bo.TurmaBO;
import com.example.demo.domain.model.Turma;

public interface TurmaRepositorieSQL {
    TurmaBO salvar(TurmaBO turma);

}
