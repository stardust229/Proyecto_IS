package com.example.OlimpiadasUNAM.Servicio;

import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Repositorio.CompetirRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCompetir {
    @Autowired
    CompetirRepositorio repo;

    public List<Competir> obtenerCompetencias(Integer numCuenta){

        return repo.obtenerCompetencias(numCuenta);
    }
}
