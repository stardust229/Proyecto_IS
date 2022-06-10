package com.example.OlimpiadasUNAM.Servicio;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Repositorio.CompetirRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCompetir {
    @Autowired
    CompetirRepositorio repo;

    public List<Competir> obtenerCompetencias(int id){
        return repo.obtenerCompetencias(id);
    }
    public List<Competir> findAllByCompetidor(Competidor competidor){
        return repo.findAllByCompetidor(competidor);
    }

    public void eliminarCompetir(Competir competir){
            repo.delete(competir);
    }
}
