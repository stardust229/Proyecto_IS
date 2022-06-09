package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Servicio.ServicioBoleta;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class COMPETIDORControlador {
     @Autowired 
    ServicioBoleta service;
     @Autowired
     ServicioCompetidor serv;
     @Autowired
    ServicioCompetir comp;
    @RequestMapping("/CompetidorLandingIH")
    public String landingCompetidor(){

        return "CompetidorLandingIH";
    }

    @GetMapping("/retroalimentacion")
    public String retroalimentacion(Model model){
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        Competidor competidor = (Competidor)auth.getPrincipal();
        int numcuenta = competidor.getNumCuenta();
         model.addAttribute("liststudent",comp.obtenerCompetencias(numcuenta));
        return "RetroalimentacionIH";
    }


    @GetMapping("/posiciones")
    public String viewHomePage(Model model) {
        List<Competir> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        return "TablaPosicionesIH";
    }



}
