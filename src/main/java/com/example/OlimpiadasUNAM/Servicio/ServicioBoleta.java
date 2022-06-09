package com.example.OlimpiadasUNAM.Servicio;

import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
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


    public Optional<Competir> get(Evento evento, Competidor competidor) {
        return repo.findByEventoAndCompetidor(evento, competidor);
    }

    /*
    public void delete(long id) {
        repo.deleteById(id);
    }*/

    public List<Competir> getTodosPorEvento(Evento evento) {
        return repo.findAllByEvento(evento);
    }

    public void save(Competir boleta) {
        repo.save(boleta);
    }

    public List<Competir> getNoCalificadosPorEvento(Evento evento) {
        List<Competir> a = repo.findAllByEventoAndPuntajeIsNull(evento);
        return a;
    }
}
