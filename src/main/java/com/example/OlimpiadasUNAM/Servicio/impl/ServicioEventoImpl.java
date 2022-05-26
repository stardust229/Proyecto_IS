package com.example.OlimpiadasUNAM.Servicio.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Repositorio.DisciplinaRepositorio;
import com.example.OlimpiadasUNAM.Repositorio.EventoRepositorio;
import com.example.OlimpiadasUNAM.Servicio.ServicioEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEventoImpl implements ServicioEvento{

    @Autowired
    private EventoRepositorio eventoRepositorio;
    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    @Override
    public Evento agregaEvento(String disciplina, String nombre, String descripcion, Date fecha) {
        Disciplina disciplinaActual = disciplinaRepositorio.findByNombre(disciplina);
        if (disciplinaActual == null) {
            return null;
        }
        Evento evento = new Evento();
        evento.setDescripcion(descripcion);
        evento.setFecha(fecha);
        evento.setNombre(nombre);
        evento.setIdEvento(disciplinaActual.getIdDisciplina());
        return eventoRepositorio.save(evento);
    }

    @Override
    public List<Evento> mostrarEventos(String disciplina) {
        Disciplina disciplinaN = disciplinaRepositorio.findByNombre(disciplina);
        if (disciplinaN == null) {
            return new ArrayList<>();
        }
        return disciplinaN.getEventos();
    }
    
}
