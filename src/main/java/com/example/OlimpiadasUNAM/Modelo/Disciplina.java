package com.example.OlimpiadasUNAM.Modelo;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Integer id;

    @Column(unique=true)
    private @Getter String nombre;

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;

    @Override
    public String toString() {
        return nombre;
    }
}
