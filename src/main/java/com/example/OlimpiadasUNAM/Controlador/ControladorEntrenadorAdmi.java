package com.example.OlimpiadasUNAM.Controlador;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenadorAdmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControladorEntrenadorAdmi {
    @Autowired
    private ServicioEntrenadorAdmi servicioEntrenador;

    @RequestMapping("/consultarEntrendoresAdmi")
    public String consultarEntrenador(){
        return "ConsultarEntrenadoresAdmi";
    }

    @GetMapping({"/consultarEntrenadoresAdmi","/consultarEntrenadorAdmi"})
    public String listarentrenadores(Model modelo, @Param("busqueda") String busqueda){
        modelo.addAttribute("entrenadores", getEntrenadoresAMostrar(busqueda));
        return "ConsultarEntrenadoresAdmi";
    }

    private List<Entrenador> getEntrenadoresAMostrar(String busqueda){
        if(busqueda != null){
            return servicioEntrenador.buscarPorNombre(busqueda);
        }
        return servicioEntrenador.obtenerTodos();
    }


}
