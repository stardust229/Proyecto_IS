package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Modelo.Disciplina;

public interface DisciplinaServicio {
    
    Disciplina agregaDisciplina(String nombre);
    
    public List<Disciplina> mostrarDisciplinas(String busqueda);

    public Disciplina consultarDisciplina(Integer id);

    public Disciplina editarDisciplina(Disciplina disciplina);

    public void eliminarDisciplina(Integer id);

    public boolean existeDisciplina(String busqueda);

}
