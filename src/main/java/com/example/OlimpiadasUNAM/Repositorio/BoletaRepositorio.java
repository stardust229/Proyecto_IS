package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OlimpiadasUNAM.Modelo.Competir;


import java.util.List;
import java.util.Optional;


@Repository
public interface BoletaRepositorio extends JpaRepository<Competir, Integer> {

    List<Competir> findAllByEvento(Evento evento);

    Optional<Competir> findById(Integer id);

    Optional<Competir> findByEventoAndCompetidor(Evento evento, Competidor competidor);
}
