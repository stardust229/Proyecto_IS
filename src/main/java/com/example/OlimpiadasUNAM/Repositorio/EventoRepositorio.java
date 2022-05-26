package com.example.OlimpiadasUNAM.Repositorio;
import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoRepositorio extends JpaRepository<Evento, Integer> {

    List<Evento> findAllByIdDisciplina(Integer idDisciplina);

    @Query("select e from Evento e where e.idDisciplina = ?1")
    List<Evento> encuentraNotasPorIdDisciplina(Integer idDisciplina);

    @Query("select e from Evento e JOIN Disciplina d ON d.idDisciplina = e.idEvento AND d.idDisciplina = ?1")
    List<Evento> encuentraNotaPorIdDisciplinaJoin(Integer idDisciplina);
    
}
