package com.example.OlimpiadasUNAM.Servicio;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Repositorio.EntrenadorAdmiRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEntrenadorAdmi {
    @Autowired
    private final EntrenadorAdmiRepositorio repositorioEntrenador;

    @Autowired
    public ServicioEntrenadorAdmi( EntrenadorAdmiRepositorio repositorioEntrenador) {
        this.repositorioEntrenador = repositorioEntrenador;
    }

    public Optional<Entrenador> buscarPorCuenta(int numCuenta){
        Optional<Entrenador> entrenadorResultado= repositorioEntrenador.findById(numCuenta);
        return entrenadorResultado;
    }

    public List<Entrenador> buscarPorNombre(String nombre){
        List<Entrenador> entrenadores = repositorioEntrenador.findAll();
        ArrayList<Entrenador> entrenadoresResultado = new ArrayList<Entrenador>();
        for(Entrenador entrenador : entrenadores){
            String nombreCompleto = String.format("%s %s %s",
                    entrenador.getNombre(),
                    entrenador.getApellidoPaterno(),
                    entrenador.getApellidoMaterno());
            int index = nombreCompleto.indexOf(nombre);
            if(index != -1) entrenadoresResultado.add(entrenador);
        }
        return entrenadoresResultado;
    }

    public List<Entrenador> buscarPorEmail(String email){
        List<Entrenador> entrenadorResultado = repositorioEntrenador.findByCorreo(email);
        return entrenadorResultado;
    }

    public List<Entrenador> obtenerTodos(){
        return repositorioEntrenador.findAll();
    }


}