package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Administrador;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Modelo.Juez;
import com.example.OlimpiadasUNAM.Modelo.ModeloUsuario;
import com.example.OlimpiadasUNAM.Servicio.ServicioAdministrador;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class ControladorLogin {

    @Autowired
    private ServicioAdministrador servicioAdmin;

    @Autowired
    private ServicioJuez servicioJuez;

    @Autowired
    private ServicioEntrenador servicioEntrenador;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String getDashboard(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        Administrador admin = servicioAdmin.buscarPorEmail(correo);

        if (admin != null) return "redirect:/admin/dashboard";
        ArrayList<Juez> jueces = (ArrayList<Juez>) servicioJuez.buscarPorEmail(correo);
        if (jueces.size()>0) return "redirect:/juez/dashboard";
        Entrenador entrenador = servicioEntrenador.buscarPorEmail(correo);
        if (entrenador != null) return "redirect:/entrenador/dashboard";
        else return "redirect:/competidor/dashboard"; // FALTA COMPETIDOR
    }

    @RequestMapping("/admin/dashboard")
    public String getAdminDashboard() { return "AdministradorLandingIH"; }


    @RequestMapping("/competidor/dashboard")
    public String getCompetidorDashboard() { return "CompetidorLandingIH"; }

}
