package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.*;

/**
 * Esta clase modela la relación Competir, que espeficica en qué evento participó cada competidor.
 */
@Entity
@IdClass(CompetirId.class)
public class Competir {

	@Id
	@ManyToOne
	private Evento evento;
	@Id
	@ManyToOne
	private Competidor competidor;
    private int puntaje;
	private String comentarios;

	public Competir() {

	}
	public Competir(Evento evento, Competidor competidor, int puntaje, String comentarios) {
		this.evento = evento;
		this.competidor = competidor;
		this.puntaje = puntaje;
		this.comentarios = comentarios;
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Competir{" +
				"evento=" + evento.getNombre() +
				", competidor=" + competidor.getNumCuenta() +
				", puntaje=" + puntaje +
				", comentarios='" + comentarios + '\'' +
				'}';
	}
}
