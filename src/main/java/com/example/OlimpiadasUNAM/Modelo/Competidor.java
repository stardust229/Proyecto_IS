package com.example.OlimpiadasUNAM.Modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="\"Competidor\"")
public class Competidor extends Usuario {
    @Column(name="disciplina")
    private String disciplina;
    @Column(name ="entrenador")
    private Long entrenador;

    public String getDisciplina() {

        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Long getEntrenado() {
        return entrenador;
    }

    public void setEntrenado(Long entrenado) {
        this.entrenador = entrenado;
    }
}

