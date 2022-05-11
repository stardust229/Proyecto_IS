package com.example.OlimpiadasUNAM.Repositorio;

import javax.transaction.Transactional;

import com.example.OlimpiadasUNAM.Modelo.Juez;

import java.util.List;

@Transactional
public interface JuezRepositorio extends UsuarioRepositorio<Juez> {

    List<Juez> findByDisciplina(String disciplina);

}
