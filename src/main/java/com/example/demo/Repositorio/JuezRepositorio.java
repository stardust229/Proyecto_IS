package com.example.demo.Repositorio;

import com.example.demo.Modelo.Juez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface JuezRepositorio extends UsuarioRepositorio<Juez> {

    List<Juez> findByDisciplina(String disciplina);

}
