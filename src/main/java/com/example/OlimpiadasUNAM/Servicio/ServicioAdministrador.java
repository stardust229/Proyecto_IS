package com.example.OlimpiadasUNAM.Servicio;

import com.example.OlimpiadasUNAM.Modelo.Administrador;
import com.example.OlimpiadasUNAM.Repositorio.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAdministrador {
    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    public ServicioAdministrador(AdministradorRepositorio administradorRepositorio) {
        this.administradorRepositorio = administradorRepositorio;
    }

    public Administrador buscarPorEmail(String email){
        List<Administrador> admins = administradorRepositorio.findByCorreo(email);
        if(admins.size() <1) return null;
        return admins.get(0);
    }
}
