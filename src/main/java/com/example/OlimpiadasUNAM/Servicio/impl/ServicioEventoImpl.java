package com.example.OlimpiadasUNAM.Servicio.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Servicio.ServicioBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Repositorio.DisciplinaRepositorio;
import com.example.OlimpiadasUNAM.Repositorio.EventoRepositorio;
import com.example.OlimpiadasUNAM.Servicio.ServicioEvento;

@Service
public class ServicioEventoImpl implements ServicioEvento {

    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;
    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Autowired
    private ServicioBoleta servicioBoleta;
    
    public List<Evento> getAllEventos(){
        return eventoRepositorio.findAll();        
    }

    public Evento agregarEvento(Evento evento){
        Disciplina disciplina = disciplinaRepositorio.findById(evento.getDisciplina().getId()).orElse(null);
        if(disciplina == null){
            disciplina = new Disciplina();
        }
        disciplina.setNombre(evento.getDisciplina().getNombre());
        evento.setDisciplina(disciplina);
        return eventoRepositorio.save(evento);
    }

    public Evento editaEvento(Evento entidad){
        return eventoRepositorio.save(entidad);
    }

    public void eliminarEvento(Integer idEvento){
        eventoRepositorio.deleteById(idEvento);
    }

    public List<Evento> mostrarEventos(Integer id) {
        Disciplina disciplina = disciplinaRepositorio.findById(id).orElse(null);
        if (disciplina == null){
            return new ArrayList<>();
        }
        return disciplina.getEventos();
    }

    public Evento consultarEvento(Integer id) {
        return eventoRepositorio.getById(id);
    }

    public boolean existeEvento(String nombre, Integer disciplina) {
        List <Evento> lista = mostrarEventos(disciplina);
        if (lista.size() < 1){
            return false;
        }else{
            for(Evento evento : lista){
                if(evento.getNombre().equalsIgnoreCase(nombre)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * @param evento
     * @return Una lista con los competidores que participaron en el evento
     */
    public List<Competidor> getCompetidores(Evento evento){
        List<Competir> boletas =  servicioBoleta.getTodosPorEvento(evento);
        ArrayList<Competidor> arr = new ArrayList<Competidor>();
        for (Competir boleta :boletas) {
            arr.add(boleta.getCompetidor());
        }
        return arr;
    }

    @Override
    public List<Evento> getAllEventos(Disciplina disciplina) {
        return eventoRepositorio.findAllByDisciplina(disciplina);
    }
}