package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetidorRepositorio extends CrudRepository<Competidor, Integer>{
    public List<Competidor> findByDisciplina(String disciplina);

    public Competidor findBynumCuenta(int numCuenta);

    public List<Competidor> findByEntrenador(Entrenador entrenador);

    public Competidor findByCorreo(String correo);
}
