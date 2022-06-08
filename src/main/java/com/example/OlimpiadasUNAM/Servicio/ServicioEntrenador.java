package com.example.OlimpiadasUNAM.Servicio;

import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioEntrenador {
    @Autowired
    private EntrenadorRepositorio repositorioEntrenador;

    public Entrenador buscarPorEmail(String email){return repositorioEntrenador.findByCorreo(email);}

    public Optional<Entrenador> buscarPorNumCuenta(int numCuenta){ return  repositorioEntrenador.findById(numCuenta); }
}
