package com.example.demo.Repositorio;

import java.util.List;

import com.example.demo.Modelo.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Integer> {

    // @Query("SELECT d from Disciplina d WHERE LOWER(d.nombre) LIKE %:busqueda%")
    @Query("SELECT d from Disciplina d WHERE d.nombre LIKE %:busqueda%")
    public List<Disciplina> findAll(String busqueda);
}
