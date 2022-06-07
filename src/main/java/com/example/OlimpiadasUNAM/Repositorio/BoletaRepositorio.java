package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.CompetirId;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OlimpiadasUNAM.Modelo.Competir;

import java.util.List;
import java.util.Optional;


@Repository
public interface BoletaRepositorio extends JpaRepository<Competir, CompetirId> {

    List<Competir> findAllByEvento(Evento evento);

    Optional<Competir> findById(CompetirId competirId);
}
