package com.example.OlimpiadasUNAM.Modelo;

import java.io.Serializable;

public class CompetirId implements Serializable {
    private Evento evento;
    private Competidor competidor;

    public CompetirId(Evento evento, Competidor competidor) {
        this.evento = evento;
        this.competidor = competidor;
    }

    public CompetirId() {
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }
}
