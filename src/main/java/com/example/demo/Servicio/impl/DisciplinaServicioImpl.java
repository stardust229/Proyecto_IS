package com.example.demo.Servicio.impl;

import java.util.List;

import com.example.demo.Modelo.Disciplina;
import com.example.demo.Repositorio.DisciplinaRepositorio;
import com.example.demo.Servicio.DisciplinaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaServicioImpl implements DisciplinaServicio {
    
    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    @Override
    public Disciplina agregaDisciplina(String nombre){
        Disciplina disciplina = new Disciplina();
        disciplina.setNombre(nombre);
        return disciplinaRepositorio.save(disciplina);
    }

    @Override
    public List<Disciplina> mostrarDisciplinas(){
        return disciplinaRepositorio.findAll();
    }

    @Override
    public Disciplina consultarDisciplina(String id) {
        return disciplinaRepositorio.getById(id);
    }

    @Override
    public Disciplina editarDisciplina(Disciplina datosNuevos) {
        return disciplinaRepositorio.saveAndFlush(datosNuevos);
    }

    @Override
    public void eliminarDisciplina(String id) {
        disciplinaRepositorio.deleteById(id);
        
    }
    
}
