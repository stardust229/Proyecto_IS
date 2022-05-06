package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.ModeloUsuario;
import com.example.OlimpiadasUNAM.Servicio.ServicioUsuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/iniciar_sesion")
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
    public String iniciarSesion(@ModelAttribute ModeloUsuario modeloUsuario, Model model){
        System.out.println("iniciarSesion request: " + modeloUsuario);
        ModeloUsuario autenticado = servicioUsuario.autenticar(modeloUsuario.getEmail(), modeloUsuario.getPassword());
        if(autenticado != null){
            model.addAttribute("iniciarSesionUsuario", autenticado.getEmail());
            return "PersonalIH";
        }else
            return "ErrorIH";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute ModeloUsuario modeloUsuario){
        System.out.println("registrar request: " + modeloUsuario);
        ModeloUsuario usuarioRegistrado = servicioUsuario.registrarUsuario(modeloUsuario.getNombre(),modeloUsuario.getEmail(), modeloUsuario.getPassword());
        return usuarioRegistrado == null ? "ErrorIH" : "redirect:/iniciar_sesion";
    }



}
