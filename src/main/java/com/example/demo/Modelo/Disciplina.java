package com.example.demo.Modelo;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Disciplina {
    @Id
    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
