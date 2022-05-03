package com.example.demo.Repositorio;

import com.example.demo.Modelo.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, String>{
    
}
