package com.example.OlimpiadasUNAM.Servicio;
import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Repositorio.CompetidorAdmiRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCompetidorAdmi {
    @Autowired
    private final CompetidorAdmiRepositorio repositorioCompetidor;

    @Autowired
    public ServicioCompetidorAdmi(CompetidorAdmiRepositorio repositorioCompetidor) {
        this.repositorioCompetidor = repositorioCompetidor;
    }

    public Optional<Competidor> buscarPorCuenta(int numCuenta){
        Optional<Competidor> competidorResultado= repositorioCompetidor.findById(numCuenta);
        return competidorResultado;
    }

    public List<Competidor> buscarPorNombre(String nombre){
        List<Competidor> competidores = repositorioCompetidor.findAll();
        ArrayList<Competidor> competidoresResultado = new ArrayList<Competidor>();
        for(Competidor competidor : competidores){
            String nombreCompleto = String.format("%s %s %s",
                    competidor.getNombre(),
                    competidor.getApellidoPaterno(),
                    competidor.getApellidoMaterno());
            int index = nombreCompleto.indexOf(nombre);
            if(index != -1) competidoresResultado.add(competidor);
        }
        return competidoresResultado;
    }

    public List<Competidor> buscarPorEmail(String email){
        List<Competidor> competidorResultado = repositorioCompetidor.findByCorreo(email);
        return competidorResultado;
    }

    public List<Competidor> obtenerTodos(){
        return repositorioCompetidor.findAll();
    }


}