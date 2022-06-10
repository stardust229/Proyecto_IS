package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ENTRENADORControlador {
    @Autowired
    ServicioCompetidor serv;
    @Autowired
    ServicioEntrenador servEnt;
    @Autowired
    ServicioEvento servicioEvento;
    @Autowired
    ServicioBoleta servicioBoleta;
    @Autowired
    ServicioUsuarios servicioUsuarios;
    @Autowired
    ServicioCompetir servicioCompetir;
    Entrenador entrenador;

    @RequestMapping("/entrenador/dashboard")
    public String getEntrenadorDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.entrenador = servEnt.buscarPorEmail(correo);
        return "EntrenadorLandingIH";
    }

    @RequestMapping("/entrenador/agregarCompetidor")
    public String agregar(Model modelo){
        modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(entrenador.getDisciplina()));
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
    public String agregar(Model modelo, HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoPaterno");
        String apellidoM = request.getParameter("apellidoMaterno");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        if (servicioUsuarios.existeUsuario(numCuenta)) {
            modelo.addAttribute("flagIDNoDisponible", true);
            return "AgregarCompetidorIH";
        } else if (servicioUsuarios.existeUsuario(correo)) {
            modelo.addAttribute("flagEmailNoDisponible", true);
            return "AgregarCompetidorIH";
        }

        Competidor competidor = new Competidor(numCuenta, nombre, apellidoP, apellidoM, institucion,
                correo, contrasena, entrenador.getDisciplina(), entrenador);
        modelo.addAttribute(competidor);

        modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(entrenador.getDisciplina()));
        return "RegistroCompetidorAEvento";
    }

    @PostMapping("/entrenador/registrarCompetidorAEvento")
    public String registrarCompetidorAEvento(Model modelo, @RequestParam(value = "id_eventos") int[] id_eventos,
                                             @RequestParam(value = "numCuenta") int numCuenta,
                                             @RequestParam(value = "nombre") String nombre,
                                             @RequestParam(value = "apellidoPaterno") String apellidoPaterno,
                                             @RequestParam(value = "apellidoMaterno") String apellidoMaterno,
                                             @RequestParam(value = "facultad") String facultad,
                                             @RequestParam(value = "correo") String correo,
                                             @RequestParam(value = "contrasenia") String contrasenia,
                                             @RequestParam(value = "id_disciplina") int id_disciplina,
                                             @RequestParam(value = "id_entrenador") int id_entrenador){
        if (servicioUsuarios.existeUsuario(numCuenta)) {
            modelo.addAttribute("flagIDNoDisponible", true);
            return "AgregarCompetidorIH";
        } else if (servicioUsuarios.existeUsuario(correo)) {
            modelo.addAttribute("flagEmailNoDisponible", true);
            return "AgregarCompetidorIH";
        }
        serv.agregarUsuario(entrenador, numCuenta, nombre, apellidoPaterno, apellidoMaterno, facultad, correo, contrasenia);
        Competidor competidor = serv.buscarCompetidor(numCuenta);
        for (Integer id: id_eventos) {
            Evento evento = servicioEvento.consultarEvento(id);
            agregarCompetidorAEvento(competidor,evento);
        }
        modelo.addAttribute("exitoAgrega", true);
        return "AgregarCompetidorIH";
    }

    @GetMapping("/entrenador/registrarCompetidorAEvento/{id}")
    public String getRegistrarCompetidoresAEvento(@PathVariable("id") Integer id, Model modelo){
        modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(entrenador.getDisciplina()));
        modelo.addAttribute("numCuentaCompetidor", id);
        return "RegistroCompetidorAEvento";
    }


    private void agregarCompetidorAEvento(Competidor competidor, Evento evento){
        Competir boleta = new Competir(evento, competidor, null, null);
        servicioBoleta.save(boleta);
    }

    @RequestMapping("/entrenador/consultarCompetidor")
    public String listaCompetidores(Model model, HttpSession session){
        model.addAttribute("competidores",serv.consultarCompetidor(entrenador));
        session.setAttribute("competidores",serv.consultarCompetidor(entrenador));
        return "ConsultarCompetidorIH";
    }

    @PostMapping("/entrenador/eliminarCompetidor")
    public String eliminar(HttpServletRequest request, Model model){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        if (serv.existeCompetidor(numCuenta)){
            Competidor competidor = serv.buscarCompetidor(numCuenta);
            if (!competidor.getEntrenador().equals(entrenador)){
                model.addAttribute("invalidNumCuenta",true);
                return "EliminarCompetidorIH";
            }
            List<Competir> dependencias = servicioCompetir.findAllByCompetidor(competidor);
            for(Competir x : dependencias){
                servicioCompetir.eliminarCompetir(x);
            }
            serv.eliminarCompetidor(entrenador, numCuenta);
            model.addAttribute("exitoElimina",true);
        }else{
            model.addAttribute("numCuentaNotFound",true);
        }
        return "EliminarCompetidorIH";
    }

    @RequestMapping(value="/entrenador/editarCompetidor",method= RequestMethod.POST, params="botonBuscar")
    public String buscarEditar(HttpServletRequest request, Model model){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        if (serv.existeCompetidor(numCuenta)){
            Competidor competidor = serv.buscarCompetidor(numCuenta);
            if(!competidor.getEntrenador().equals(entrenador)){
                model.addAttribute("invalidNumCuenta",true);
                return "EditarCompetidorIH";
            }
            model.addAttribute("competidor",competidor);
            model.addAttribute("searchSuccess",true);
        }else{
            model.addAttribute("numCuentaNotFound",true);
        }
        return "EditarCompetidorIH";
        }

    @RequestMapping(value="/entrenador/editarCompetidor",method=RequestMethod.POST, params="botonEditar")
    public String Editar(HttpServletRequest request, Model model){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoPaterno");
        String apellidoM = request.getParameter("apellidoMaterno");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        Competidor comp = serv.buscarCompetidor(correo);
        if (comp != null && !(comp.getNumCuenta() == numCuenta)){
            model.addAttribute("flagEmailNoDisponible",true);
        }else {
            serv.actualizarCompetidor(entrenador, numCuenta, nombre, apellidoP, apellidoM, institucion, correo, contrasena);
            model.addAttribute("exitoEdita",true);
        }
        return "EditarCompetidorIH";
    }

    @RequestMapping("/EntrenadorLandingIH")
    public String landingEntrenador(){
        return "EntrenadorLandingIH";
    }
    
    @GetMapping("/entrenador/calificacionesEntrenador")
    public String viewHomePage(Model model) {
	    List<Competir> liststudent = servicioBoleta.listAll();
	    model.addAttribute("liststudent", liststudent);
	    return "ConsultarCalificacionesEntrenadorIH";
    }

}
