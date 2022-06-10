package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.*;
import com.example.OlimpiadasUNAM.Servicio.ServicioAdministrador;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;
import com.example.OlimpiadasUNAM.Servicio.ServicioUsuarios;
import com.example.OlimpiadasUNAM.Servicio.impl.DisciplinaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ControladorLogin {

    @Autowired
    private ServicioAdministrador servicioAdmin;

    @Autowired
    private ServicioJuez servicioJuez;

    @Autowired
    private ServicioEntrenador servicioEntrenador;

    @Autowired
    private DisciplinaServicioImpl servicioDisciplina;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping({"/login", "/"})
    public String getLogin() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String getDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        Administrador admin = servicioAdmin.buscarPorEmail(correo);

        if (admin != null) return "redirect:/admin/dashboard";
        ArrayList<Juez> jueces = (ArrayList<Juez>) servicioJuez.buscarPorEmail(correo);
        if (jueces.size() > 0) return "redirect:/juez/dashboard";
        Entrenador entrenador = servicioEntrenador.buscarPorEmail(correo);
        if (entrenador != null) return "redirect:/entrenador/dashboard";
        else return "redirect:/competidor/dashboard"; // FALTA COMPETIDOR
    }

    @RequestMapping("/admin/dashboard")
    public String getAdminDashboard() {
        return "AdministradorLandingIH";
    }


    @RequestMapping("/registroEntrenador")
    public String getRegisterPage(Model model) {
        cargarDisciplinas(model);
        return "RegistroEntrenadorIH";
    }

    @PostMapping("/registroEntrenador")
    public String registrarEntrenador(HttpServletRequest request, Model modelo) {
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoPaterno");
        String apellidoM = request.getParameter("apellidoMaterno");
        String correo = request.getParameter("correo");
        String facultad = request.getParameter("facultad");
        String contrasenia = request.getParameter("contrasenia");
        Integer disciplina = Integer.parseInt(request.getParameter("disciplina"));
        Disciplina dis = servicioDisciplina.consultarDisciplina(disciplina);
        cargarDisciplinas(modelo);
        if (servicioUsuarios.existeUsuario(numCuenta)) {
            modelo.addAttribute("flagIDNoDisponibleRE", true);
            return "RegistroEntrenadorIH";
        } else if (servicioUsuarios.existeUsuario(correo)) {
            modelo.addAttribute("flagEmailNoDisponibleRE", true);
            return "RegistroEntrenadorIH";
        }
        servicioEntrenador.agregarEntrenador(numCuenta, nombre, apellidoP, apellidoM, facultad, correo, contrasenia,dis);
        modelo.addAttribute("exitoAgregaRE", true);
        return "RegistroEntrenadorIH";
    }

    public void cargarDisciplinas(Model model){
        List<Disciplina> disciplinas = servicioDisciplina.findAllDisciplinas();
        model.addAttribute("disciplinas",disciplinas);
    }

}
