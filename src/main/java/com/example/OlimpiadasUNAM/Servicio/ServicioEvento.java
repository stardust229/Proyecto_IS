package com.example.OlimpiadasUNAM.Servicio;

import java.sql.Date;
import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Evento;

public interface ServicioEvento {
    Evento agregaEvento(String disciplina, String nombre, String descripcion, Date fecha);
    
    List<Evento> mostrarEventos(String disciplina);
}
