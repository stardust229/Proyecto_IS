package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boleta {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String competidor;
    private String disciplina;
    private int calificacion;
	private String comentario;
	public Boleta() {

	}
	public Boleta(Long id, String competidor, String disciplina, int calificacion, String comentario) {

		this.id = id;
		this.competidor = competidor;
		this.disciplina = disciplina;
		this.calificacion = calificacion;
		this.comentario = comentario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompetidor() {
		return competidor;
	}
	public void setCompetidor(String competidor) {
		this.competidor = competidor;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
