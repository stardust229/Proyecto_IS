package com.example.OlimpiadasUNAM.Servicio;

import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.Evento;

public interface ServicioEvento {

    public List<Evento> getAllEventos();

    public List<Evento> getAllEventos(Disciplina disciplina);

    public Evento agregarEvento(Evento evento);

    public Evento editaEvento(Evento entidad);

    public void eliminarEvento(Integer idEvento);

    public List<Evento> mostrarEventos(Integer id);

    public Evento consultarEvento(Integer id);

    public boolean existeEvento(String nombre, Integer disciplina);

    public List<Competidor> getCompetidores(Evento evento);

}
