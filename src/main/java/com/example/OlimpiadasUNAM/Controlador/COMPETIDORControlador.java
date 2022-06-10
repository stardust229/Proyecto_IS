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

     Competidor competidor;
    @RequestMapping("/CompetidorLandingIH")
    public String landingCompetidor(){

        return "CompetidorLandingIH";
    }
    @RequestMapping("/competidor/dashboard")
    public String getCompetidorDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.competidor = serv.buscarCompetidor(correo);
        return "CompetidorLandingIH";

    }

    @GetMapping("/retroalimentacion")
    public String retroalimentacion(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.competidor = serv.buscarCompetidor(correo);
        int numCuenta = competidor.getNumCuenta();
        model.addAttribute("competencias",comp.obtenerCompetencias(numCuenta));
        return "RetroalimentacionIH";
    }


    @GetMapping("/tablaposiciones")
    public String viewHomePage(Model model) {
        List<Competir> liststudent = service.listAll();

        model.addAttribute("liststudent", liststudent);
        return "TablaPosicionesIH";
    }



}
