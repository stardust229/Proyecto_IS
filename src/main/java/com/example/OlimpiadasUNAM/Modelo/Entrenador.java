package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Entrenador extends Usuario{
    @Column(name = "disciplina")
    private String disciplina;


    public Entrenador(int numCuenta, String nombre, String apellidoPaterno, String apellidoMaterno, String facultad, String correo, String contrasenia, String disciplina) {
        super(numCuenta, nombre, apellidoPaterno, apellidoMaterno, facultad, correo, contrasenia);
        this.disciplina = disciplina;
    }

    public Entrenador(){
        super();
    }
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        disciplina = disciplina;
    }



}
