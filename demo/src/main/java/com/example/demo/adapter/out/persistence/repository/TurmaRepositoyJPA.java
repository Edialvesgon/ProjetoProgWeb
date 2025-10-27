package com.example.demo.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.adapter.out.persistence.entity.TurmaDAOEntity;

public interface TurmaRepositoyJPA extends JpaRepository<TurmaDAOEntity, Integer> {
    TurmaDAOEntity findByNome(String nome);

    TurmaDAOEntity findByCurso(String nome);

}
