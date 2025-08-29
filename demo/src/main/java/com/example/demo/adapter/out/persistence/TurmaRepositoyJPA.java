package com.example.demo.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.adapter.out.dao.TurmaDAO;
import com.example.demo.adapter.out.dao.TurmaDAOEntity;

public interface TurmaRepositoyJPA extends JpaRepository<TurmaDAOEntity, Integer> {

}
