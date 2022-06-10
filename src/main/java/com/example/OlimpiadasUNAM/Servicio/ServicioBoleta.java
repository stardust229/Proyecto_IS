package com.example.OlimpiadasUNAM.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Repositorio.BoletaRepositorio;

@Service
public class ServicioBoleta {

	@Autowired
    private BoletaRepositorio repo;
    @Autowired
    private EventoRepositorio eventoRepositorio;

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

    public List<Competir> getTodosPorDisciplina(Disciplina disciplina){
        List<Evento> eventos = eventoRepositorio.findAllByDisciplina(disciplina);
        ArrayList<Competir> boletas = new ArrayList<Competir>();
        for (Evento evento: eventos) {
            for (Competir boleta: getTodosPorEvento(evento)) {
                boletas.add(boleta);
            }
        }
        return boletas;
    }

    public void save(Competir boleta) {
        repo.save(boleta);
    }

    public List<Competir> getNoCalificadosPorEvento(Evento evento) {
        List<Competir> a = repo.findAllByEventoAndPuntajeIsNull(evento);
        return a;
    }

    public List<Competir> getTodosPorEventoOrdenDescendiente(Evento evento) {
        List<Competir> boletas = repo.findAllByEventoOrderByPuntajeDesc(evento);
        ArrayList<Competir> boletasSinNull = new ArrayList<Competir>();

        for (Competir boleta: boletas) {
            if (boleta.getPuntaje() != null) boletasSinNull.add(boleta);
        }
        return boletasSinNull;
    }
}
