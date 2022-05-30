package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;

@Entity
public class Competidor extends Usuario{
    String disciplina = null;
    int numCuentaEntrenador = 0;

    public Competidor(){}

    public Competidor(int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion,
                      String correo, String contrasena, String disciplina, int numCuentaEntrenador){
        super(numCuenta ,nombre ,apellidoP ,apellidoM , institucion, correo ,contrasena);
        this.disciplina = disciplina;
        this.numCuentaEntrenador = numCuentaEntrenador;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public void setNumCuentaEntrenador(int numCuentaEntrenador){
        this.numCuentaEntrenador = numCuentaEntrenador;
    }

    public String getDisciplina(){
        return this.disciplina;
    }
    public int getNumCuentaEntrenador(){
        return this.numCuentaEntrenador;
    }
}
