package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Administrador;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Modelo.ModeloUsuario;
import com.example.OlimpiadasUNAM.Servicio.ServicioAdministrador;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {

    @Autowired
    private final ServicioJuez servicioJuez;
    @Autowired
    private final ServicioAdministrador servicioAdministrador;
    @Autowired
    private ServicioEntrenador servicioEntrenador;

    public ControladorUsuario(ServicioJuez servicioJuez, ServicioAdministrador servicioAdministrador) {
        this.servicioJuez = servicioJuez;
        this.servicioAdministrador = servicioAdministrador;
    }

    @GetMapping({"/iniciar_sesion","/"})
    public String getLoginPage(Model model){
        model.addAttribute("iniciarSesionRequest", new ModeloUsuario());
        return "IniciarSesionIH";
    }


    @GetMapping("/registrar")
    public String getRegisterPage(Model model){
        model.addAttribute("registrarRequest", new ModeloUsuario());
        return "registrar_page";
    }

    @PostMapping("/iniciar_sesion")
    public String iniciarSesion(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String contra = request.getParameter("password");
        String tipoUsuario = request.getParameter("tipoUsuario");
        switch(tipoUsuario) {
            case "1":
                if (autenticarAdmin(email, contra)) {
                    model.addAttribute("iniciarSesionUsuario", email);
                    return "AdministradorLandingIH";
                }else {
                    return "ErrorIH";
                }
            case "3":
                if(autenticarEntrenador(email,contra)){
                    model.addAttribute("iniciarSesionUsuario", email);
                    System.out.println("Email: " + email);
                    return "redirect:/DashboardEntrenadorIH";
                }else{
                    return "ErrorIH";
                }
            default:
                return "ErrorIH";
        }
    }

    @GetMapping("/cerrar_sesion")
    public String cerrarSesion(){

        return "redirect:/logout";
    }

    /*
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute ModeloUsuario modeloUsuario){
        System.out.println("registrar request: " + modeloUsuario);
        ModeloUsuario usuarioRegistrado = servicioUsuario.registrarUsuario(modeloUsuario.getNombre(),modeloUsuario.getEmail(), modeloUsuario.getPassword());
        return usuarioRegistrado == null ? "ErrorIH" : "redirect:/iniciar_sesion";
    }*/

    private boolean autenticarAdmin(String email, String contra){
        Administrador admin = servicioAdministrador.buscarPorEmail(email);
        if(admin == null) return false;
        if(admin.getContrasenia().equals(contra)) return true;
        return false;
    }

    private boolean autenticarEntrenador(String email, String contra){
        Entrenador entrenador = servicioEntrenador.buscarPorEmail(email);
        if(entrenador == null) return false;
        if(entrenador.getContrasenia().equals(contra)) return true;
        return false;
    }
}
