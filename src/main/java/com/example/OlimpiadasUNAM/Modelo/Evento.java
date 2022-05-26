package com.example.OlimpiadasUNAM.Modelo;
import java.sql.Date;
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

    @DateTimeFormat(pattern = "yyyy-DD-MM")
    @Column
    private Date fecha;

    @Column
    private String descripcion;

    @Column(name = "iddisciplina")
    private Integer idDisciplina;

    @ManyToOne(targetEntity = Disciplina.class)
    @JoinColumn(name = "disciplina", referencedColumnName = "iddisciplina", nullable = false, insertable = false, updatable = false)
    private Disciplina disciplina;
}
