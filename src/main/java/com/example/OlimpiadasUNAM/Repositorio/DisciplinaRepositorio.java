package com.example.OlimpiadasUNAM.Repositorio;

import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepositorio extends JpaRepository<Disciplina, Integer> {

    // @Query("SELECT d from Disciplina d WHERE LOWER(d.nombre) LIKE %:busqueda%")
    @Query("SELECT d from Disciplina d WHERE d.nombre LIKE %:busqueda%")
    public List<Disciplina> findAll(String busqueda);

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Disciplina d WHERE d.nombre = :busqueda")
    boolean existsByName(String busqueda);

    public List<Disciplina> findAll();
}
