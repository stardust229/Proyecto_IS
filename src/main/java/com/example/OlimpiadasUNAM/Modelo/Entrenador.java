
package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;

@Entity
public class Entrenador extends Usuario{
    String disciplina = null;

    public Entrenador(){}
    public Entrenador(int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion, String correo, String contrasena, String disciplina){
        super(numCuenta ,nombre ,apellidoP ,apellidoM , institucion, correo ,contrasena);
        this.disciplina = disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina(){
        return this.disciplina;
    }
}