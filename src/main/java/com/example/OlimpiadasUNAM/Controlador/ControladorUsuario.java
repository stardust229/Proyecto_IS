package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Administrador;
import com.example.OlimpiadasUNAM.Modelo.ModeloUsuario;
import com.example.OlimpiadasUNAM.Servicio.ServicioAdministrador;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;
import com.example.OlimpiadasUNAM.Servicio.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {

    @Autowired
    private final ServicioJuez servicioJuez;
    @Autowired
    private final ServicioAdministrador servicioAdministrador;

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
        if(autenticarAdmin(email,contra)){
            model.addAttribute("iniciarSesionUsuario", email);
            return "AdministradorLandingIH";
        }else
            return "ErrorIH";
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


}
