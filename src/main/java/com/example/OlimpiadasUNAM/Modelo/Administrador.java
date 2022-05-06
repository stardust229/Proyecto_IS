package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Administrador extends Usuario{

    public Administrador(int numCuenta, String nombre, String apellidoPaterno, String apellidoMaterno, String facultad, String correo, String contrasenia, String disciplina) {
        super(numCuenta, nombre, apellidoPaterno, apellidoMaterno, facultad, correo, contrasenia);
    }

    public Administrador(){
        super();
    }
}
