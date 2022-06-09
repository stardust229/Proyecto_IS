package com.example.OlimpiadasUNAM.Repositorio;
import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Integer>{


    List<Evento> findAllByDisciplina(Disciplina disciplina);
}
