package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Entrenador extends Usuario{
    @ManyToOne(fetch = FetchType.LAZY)
    private Disciplina disciplina;

    public Entrenador(){}

    public Entrenador(int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion, String correo, String contrasena, Disciplina disciplina){
        super(numCuenta ,nombre ,apellidoP ,apellidoM , institucion, correo ,contrasena, "ENTRENADOR");
        this.disciplina = disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina(){
        return this.disciplina;
    }

    @Override
    public boolean equals(Object obj) {
        if (! obj.getClass().equals(this.getClass())) return false;
        Entrenador entrenadorAComparar = (Entrenador)obj;
        return this.getNumCuenta() == entrenadorAComparar.getNumCuenta();
    }
}
