package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Modelo.Disciplina;

public interface DisciplinaServicio {
    
    Disciplina agregaDisciplina(String nombre);
    
    public List<Disciplina> mostrarDisciplinas();

    public Disciplina consultarDisciplina(String nombre);

    public Disciplina editarDisciplina(Disciplina disciplina);

    public void eliminarDisciplina(String nombre);

}
