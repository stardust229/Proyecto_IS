package com.example.OlimpiadasUNAM.Servicio;

import java.util.List;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;

public interface DisciplinaServicio {
    
    Disciplina agregaDisciplina(String nombre);
    
    public List<Disciplina> mostrarDisciplinas(String busqueda);

    public Disciplina consultarDisciplina(Integer id);

    public Disciplina editarDisciplina(Disciplina disciplina);

    public void eliminarDisciplina(Integer id);

    public boolean existeDisciplina(String busqueda);

}
