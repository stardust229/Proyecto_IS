package com.example.OlimpiadasUNAM.Controlador;
import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidorAdmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControladorCompetidorAdmi {
    @Autowired
    private ServicioCompetidorAdmi servicioCompetidor;

    @RequestMapping("/consultarCompetidoresAdmi")
    public String consultarCompetidor(){
        return "ConsultarCompetidoresAdmi";
    }

    @GetMapping({"/consultarCompetidoresAdmi","/consultarCompetidorAdmi"})
    public String listarentrenadores(Model modelo, @Param("busqueda") String busqueda){
        modelo.addAttribute("competidores", getCompetidoresAMostrar(busqueda));
        return "ConsultarCompetidoresAdmi";
    }

    private List<Competidor> getCompetidoresAMostrar(String busqueda){
        if(busqueda != null){
            return servicioCompetidor.buscarPorNombre(busqueda);
        }
        return servicioCompetidor.obtenerTodos();
    }


}

