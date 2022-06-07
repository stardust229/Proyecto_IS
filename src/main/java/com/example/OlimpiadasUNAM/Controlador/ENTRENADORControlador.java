package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ENTRENADORControlador {
    @Autowired
    ServicioCompetidor serv;
    @Autowired
    ServicioEntrenador servEnt;
    Entrenador entrenador;

    @RequestMapping("/entrenador/dashboard")
    public String getEntrenadorDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.entrenador = servEnt.buscarPorEmail(correo);
        return "EntrenadorLandingIH";
    }

    @RequestMapping("/entrenador/agregarCompetidor")
    public String agregar(){
        return "AgregarCompetidorIH";
    }
    @RequestMapping("/entrenador/eliminarCompetidor")
    public String eliminar(){
        return "EliminarCompetidorIH";
    }
    @RequestMapping("/entrenador/editarCompetidor")
    public String editar(){
        return "EditarCompetidorIH";
    }

    @PostMapping("/entrenador/agregarCompetidor")
    public String agregar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoPaterno");
        String apellidoM = request.getParameter("apellidoMaterno");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        serv.agregarUsuario(entrenador, numCuenta, nombre, apellidoP, apellidoM, institucion, correo, contrasena);
        List<Competidor> it = serv.consultarCompetidor(entrenador);
        return "AgregarCompetidorIH";
        }

    @RequestMapping("/entrenador/consultarCompetidor")
    public String listaCompetidores(Model model, HttpSession session){
        model.addAttribute("competidores",serv.consultarCompetidor(entrenador));
        session.setAttribute("competidores",serv.consultarCompetidor(entrenador));
        return "ConsultarCompetidorIH";
    }

    @PostMapping("/entrenador/eliminarCompetidor")
    public String eliminar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        serv.eliminarCompetidor(entrenador, numCuenta);
        return "EliminarCompetidorIH";
    }

    @RequestMapping(value="/entrenador/editarCompetidor",method= RequestMethod.POST, params="botonBuscar")
    public String buscarEditar(HttpServletRequest request, Model model){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        Competidor competidor = serv.buscarCompetidor(numCuenta);
        model.addAttribute("competidor", competidor);
        return "EditarCompetidorIH";
    }

    @RequestMapping(value="/entrenador/editarCompetidor",method=RequestMethod.POST, params="botonEditar")
    public String Editar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoPaterno");
        String apellidoM = request.getParameter("apellidoMaterno");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        serv.actualizarCompetidor(entrenador, numCuenta, nombre, apellidoP, apellidoM, institucion, correo, contrasena);
        return "EditarCompetidorIH";
    }

    @RequestMapping("/EntrenadorLandingIH")
    public String landingEntrenador(){
        return "EntrenadorLandingIH";
    }

}
