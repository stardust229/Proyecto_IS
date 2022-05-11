package com.example.OlimpiadasUNAM.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Juez;
import com.example.OlimpiadasUNAM.Repositorio.JuezRepositorio;

@Service
public class ServicioJuez {

    private final JuezRepositorio juezRepositorio;

    @Autowired
    public ServicioJuez(JuezRepositorio juezRepositorio) {
        this.juezRepositorio = juezRepositorio;
    }

    public void agregar(Juez juez) throws IDNodisponibleExcepcion {
        Optional<Juez> juezOptional = juezRepositorio.findById(juez.getNumCuenta());
        if(juezOptional.isPresent()){
            throw new IDNodisponibleExcepcion("Se trató de agregar a un juez que ya estaba registrado.");
        }
        juezRepositorio.save(juez);
    }

    public Optional<Juez> buscarPorCuenta(int numCuenta){
        Optional<Juez> juezResultado = juezRepositorio.findById(numCuenta);
        return juezResultado;
    }

    public List<Juez> buscarPorNombre(String nombre){
        List<Juez> jueces = juezRepositorio.findAll();
        ArrayList<Juez> juecesResultado = new ArrayList<Juez>();
        for(Juez juez : jueces){
            String nombreCompleto = String.format("%s %s %s",
                    juez.getNombre(),
                    juez.getApellidoPaterno(),
                    juez.getApellidoMaterno());
            int index = nombreCompleto.indexOf(nombre);
            if(index != -1) juecesResultado.add(juez);
        }
        return juecesResultado;
    }

    public List<Juez> buscarPorEmail(String email){
        List<Juez> juezResultado = juezRepositorio.findByCorreo(email);
        return juezResultado;
    }

    public List<Juez> buscarPorDisciplina(String disciplina){
        List<Juez> juezResultado = juezRepositorio.findByDisciplina(disciplina);
        return juezResultado;
    }

    public List<Juez> buscarPorFacultad(String facultad){
        List<Juez> juezResultado = juezRepositorio.findByFacultad(facultad);
        return juezResultado;
    }

    public List<Juez> obtenerTodos(){
        return juezRepositorio.findAll();
    }

    public void eliminar(int numCuenta){
        juezRepositorio.deleteById(numCuenta);
    }

    // Pasar el número de cuenta es inecesario
    public void editar(Juez juezNuevo){
        Optional<Juez> juezOptional = juezRepositorio.findById(juezNuevo.getNumCuenta());
        if(juezOptional.isPresent()){
            throw new IllegalStateException("Se trató de agregar a un juez que ya estaba registrado.");
        }
        juezRepositorio.save(juezNuevo);
    }
}
