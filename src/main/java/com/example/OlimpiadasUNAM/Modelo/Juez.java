package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Juez extends Usuario{

    @ManyToOne
    private Disciplina disciplina;


    public Juez(int numCuenta, String nombre, String apellidoPaterno, String apellidoMaterno, String facultad, String correo, String contrasenia, Disciplina disciplina) {
        super(numCuenta, nombre, apellidoPaterno, apellidoMaterno, facultad, correo, contrasenia);
        this.disciplina = disciplina;
    }

    public Juez(){
        super();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}