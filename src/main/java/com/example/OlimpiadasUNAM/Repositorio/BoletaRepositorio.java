package com.example.OlimpiadasUNAM.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OlimpiadasUNAM.Modelo.Boleta;


@Repository
public interface BoletaRepositorio extends JpaRepository<Boleta, Long> {

}
