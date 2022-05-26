package com.example.OlimpiadasUNAM.Repositorio;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface RepositorioEntrenador extends UsuarioRepositorio<Entrenador>{

}
