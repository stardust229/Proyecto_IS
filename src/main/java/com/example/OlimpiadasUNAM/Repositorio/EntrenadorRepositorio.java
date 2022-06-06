package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepositorio extends CrudRepository<Entrenador, Integer>{
    public Entrenador findByCorreo(String correo);
}
