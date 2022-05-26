package com.example.OlimpiadasUNAM.Servicio;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Repositorio.RepositorioEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEntrenador {

    private final RepositorioEntrenador entrenadorRepositorio;
    @Autowired
    public ServicioEntrenador(RepositorioEntrenador entrenadorRepositorio) {
        this.entrenadorRepositorio = entrenadorRepositorio;
    }

    public List<Entrenador> buscarPorNombre(String nombre){
        List<Entrenador> entrenadores = entrenadorRepositorio.findAll();
        ArrayList<Entrenador> entrenadorResultado = new ArrayList<Entrenador>();
        for(Entrenador entrenador : entrenadores){
            String nombreCompleto = String.format("%s %s %s",
                    entrenador.getNombre(),
                    entrenador.getApellidoPaterno(),
                    entrenador.getApellidoMaterno());
            int index = nombreCompleto.indexOf(nombre);
            if(index != -1) entrenadorResultado.add(entrenador);
        }
        return entrenadorResultado;
    }

    public List<Entrenador> obtenerTodos(){
        return entrenadorRepositorio.findAll();
    }

}
