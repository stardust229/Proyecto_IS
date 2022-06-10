package com.example.OlimpiadasUNAM.Modelo;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

@Data
@Entity
@Table
public class Evento { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idevento")
    private Integer idEvento;

    @Column
    private String nombre;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column
    private Date fecha;

    @Column
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="disciplina_id"), name="disciplina_id")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Competir> competencias;


}
