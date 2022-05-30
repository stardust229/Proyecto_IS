package com.example.OlimpiadasUNAM.Servicio;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Repositorio.CompetidorRepositorio;
import com.example.OlimpiadasUNAM.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCompetidor {
    @Autowired
    private CompetidorRepositorio repositorioCompetidor;
    private EntrenadorRepositorio repositorioEntrenador;

    public void agregarUsuario(Entrenador entrenador,int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion,
                               String correo, String contrasena){
            Competidor competidor = new Competidor(numCuenta ,nombre ,apellidoP ,apellidoM ,institucion ,
                    correo ,contrasena , entrenador.getDisciplina() , entrenador.getNumCuenta());
            repositorioCompetidor.save(competidor);
    }

    public List<Competidor> consultarCompetidor(Entrenador entrenador){
        return repositorioCompetidor.findByDisciplina(entrenador.getDisciplina());
    }

    public Competidor buscarCompetidor(int numCuenta){
        return repositorioCompetidor.findBynumCuenta(numCuenta);
    }

    public boolean eliminarCompetidor(Entrenador entrenador, int numCuenta){
        Competidor competidor = buscarCompetidor(numCuenta);
        if(competidor.getNumCuentaEntrenador() == entrenador.getNumCuenta()){
            repositorioCompetidor.delete(competidor);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarCompetidor(Entrenador entrenador,int numCuenta, String nombre, String apellidoP, String apellidoM, String institucion,
                                     String correo, String contrasena){
        Competidor competidor = buscarCompetidor(numCuenta);
        if(competidor.getNumCuentaEntrenador() == entrenador.getNumCuenta()){
            competidor.setNombre(nombre);
            competidor.setApellidoPaterno(apellidoP);
            competidor.setApellidoMaterno(apellidoM);
            competidor.setFacultad(institucion);
            competidor.setCorreo(correo);
            competidor.setContrasenia(contrasena);
            competidor.setDisciplina(entrenador.getDisciplina());
            repositorioCompetidor.save(competidor);
            return true;
        }else{
            return false;
        }
    }
}
