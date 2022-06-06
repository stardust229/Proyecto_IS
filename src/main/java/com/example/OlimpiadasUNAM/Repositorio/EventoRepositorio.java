package com.example.OlimpiadasUNAM.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Integer>{

    
}
