package com.example.OlimpiadasUNAM.Servicio;

import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.CompetirId;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Repositorio.BoletaRepositorio;

@Service
public class ServicioBoleta {

	@Autowired
    private BoletaRepositorio repo;

	public List<Competir> listAll() {
        return repo.findAll();
    }

    public void save(Competir std) {
        repo.save(std);
    }

    public Optional<Competir> get(Evento evento, Competidor competidor) {
        return repo.findById(new CompetirId(evento, competidor));
    }

    /*
    public void delete(long id) {
        repo.deleteById(id);
    }*/

    public List<Competir> getTodosPorEvento(Evento evento) {
        return repo.findAllByEvento(evento);
    }

}
