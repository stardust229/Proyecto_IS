package com.example.OlimpiadasUNAM.Servicio.impl;

import java.util.ArrayList;
import java.util.List;

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
   
}