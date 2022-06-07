package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Competidor extends Usuario{
    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Entrenador entrenador;

    public Competidor(){}

    public Competidor(int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion,
                      String correo, String contrasena, Disciplina disciplina, Entrenador entrenador){
        super(numCuenta ,nombre ,apellidoP ,apellidoM , institucion, correo ,contrasena, "COMPETIDOR");
        this.disciplina = disciplina;
        this.entrenador = entrenador;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    public void setEntrenador(Entrenador entrenador){
        this.entrenador = entrenador;
    }

    public Disciplina getDisciplina(){
        return this.disciplina;
    }
    public Entrenador getEntrenador(){
        return this.entrenador;
    }
}
