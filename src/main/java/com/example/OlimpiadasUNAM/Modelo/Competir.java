package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.*;

/**
 * Esta clase modela la relación Competir, que espeficica en qué evento participó cada competidor.
 */
@Entity
public class Competir {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompetir;
	@ManyToOne
	private Evento evento;
	@ManyToOne
	private Competidor competidor;

	@Column(nullable = true)
    private Integer puntaje;
	@Column(nullable = true)
	private String comentarios;

	public Competir() {

	}
	public Competir(Evento evento, Competidor competidor, Integer puntaje, String comentarios) {
		this.evento = evento;
		this.competidor = competidor;
		this.puntaje = puntaje;
		this.comentarios = comentarios;
	}

	public Integer getIdCompetir() {
		return idCompetir;
	}

	public void setIdCompetir(Integer idCompetir) {
		this.idCompetir = idCompetir;
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

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
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
