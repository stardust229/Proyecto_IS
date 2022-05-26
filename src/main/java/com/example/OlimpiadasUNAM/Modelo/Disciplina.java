package com.example.OlimpiadasUNAM.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddisciplina")
    private Integer idDisciplina;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "disciplina", targetEntity = Evento.class)
    private List<Evento> eventos = new ArrayList<>();

    public Integer getId() {
        return idDisciplina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
