package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioEntrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ControladorEntrenador {
    @Autowired
    ServicioCompetidor serv;
    @Autowired
    ServicioEntrenador servEnt;
    Entrenador entrenador;

    @GetMapping("/entrenador")
    public String inicioEntrenador(Model model){

        //correo sale como null, problema sacando el correo del modelo.
        String correo = (String)model.asMap().get("iniciarSesionUsuario");
        System.out.println("Correo de usuario: " + correo);
        this.entrenador = servEnt.buscarPorEmail(correo);
        System.out.println("Usuario: "+entrenador.getNumCuenta());
        return "DashboardEntrenadorIH";
    }


    @GetMapping("/agregar")
    public String agregar(){
        return "AgregarCompetidorIH";
    }
    @GetMapping("/eliminar")
    public String eliminar(){
        return "EliminarCompetidorIH";
    }
    @GetMapping("/editar")
    public String editar(){
        return "EditarCompetidorIH";
    }

    @PostMapping("/agregarCompetidor")
    public String agregar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        serv.agregarUsuario(entrenador, numCuenta, nombre, apellidoP, apellidoM, institucion, correo, contrasena);
        List<Competidor> it = serv.consultarCompetidor(entrenador);
        return "AgregarCompetidorIH";
        }

    @RequestMapping("/consultar")
    public String listaCompetidores(Model model, HttpSession session){
        model.addAttribute("competidores",serv.consultarCompetidor(entrenador));
        session.setAttribute("competidores",serv.consultarCompetidor(entrenador));
        return "ConsultarCompetidorIH";
    }

    @PostMapping("/eliminarCompetidor")
    public String eliminar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("cuenta"));
        serv.eliminarCompetidor(entrenador, numCuenta);
        return "EliminarCompetidorIH";
    }

    @RequestMapping(value="/editarCompetidor",method= RequestMethod.POST, params="Buscar")
    public String buscarEditar(HttpServletRequest request, Model model){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        Competidor competidor = serv.buscarCompetidor(numCuenta);
        model.addAttribute("competidor", competidor);
        return "EditarCompetidorIH";
    }

    @RequestMapping(value="/editarCompetidor",method=RequestMethod.POST, params="Editar")
    public String Editar(HttpServletRequest request){
        Integer numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String institucion = request.getParameter("institucion");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        serv.actualizarCompetidor(entrenador, numCuenta, nombre, apellidoP, apellidoM, institucion, correo, contrasena);
        return "EditarCompetidorIH";
    }

}
