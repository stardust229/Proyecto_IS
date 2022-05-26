package com.example.OlimpiadasUNAM.Controlador;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ControladorConsultas {
    @Autowired
    private ServicioEntrenador serv;

    @RequestMapping("/consultarEntrenadorIH")
    public String consultarEntrenadorIH(){
        return "ConsultarEntrenadorIH";
    }
    @GetMapping({"/consultarEntrenadorIH","/consultarEntrenador"})
    public String listarEntrenadores(Model modelo, @Param("busqueda") String busqueda){
        modelo.addAttribute("entrenador", getEntrenadoresAMostrar(busqueda));
        return "ConsultarEntrenadorIH";
    }
    private List<Entrenador> getEntrenadoresAMostrar(String busqueda){
        if(busqueda != null){
            return serv.buscarPorNombre(busqueda);
        }
        return serv.obtenerTodos();
    }
}
