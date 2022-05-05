package com.example.demo.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Juez extends Usuario{

    private String disciplina;


    public Juez(int numCuenta, String nombre, String apellidoPaterno, String apellidoMaterno, String facultad, String correo, String contrasenia, String disciplina) {
        super(numCuenta, nombre, apellidoPaterno, apellidoMaterno, facultad, correo, contrasenia);
        this.disciplina = disciplina;
    }

    public Juez(){
        super();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
