package com.example.demo.Controlador;

import com.example.demo.Modelo.Juez;
import com.example.demo.Servicio.IDNodisponibleExcepcion;
import com.example.demo.Servicio.ServicioJuez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorCRUDJuez {

    @Autowired
    private ServicioJuez servicioJuez;

    @RequestMapping("/agregarJuezIH")
    public String agregarJuezIH(){
        return "AgregarJuezIH";
    }

    @RequestMapping("/consultarJuezIH")
    public String consultarJuezIH(){
        return "ConsultarJuezIH";
    }

    // http://localhost:8000/agregarJuez
    /*
     * en el modelo que regresa, flagIDNoDisponible es true si ya había un juez
     * con el número de cuenta que se ingresó, false si no.
     */
    @PostMapping("/agregarJuez")
    public String agregar(HttpServletRequest request, Model model) {
        int numCuenta = Integer.parseInt(request.getParameter("numCuenta"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String facultad = request.getParameter("facultad");
        String correo = request.getParameter("correo");
        String disciplina = request.getParameter("disciplina");

        String contrasenia = "thatthatilikethat"; // la contra se debe generar de forma random

        Juez juez = new Juez(numCuenta,nombre,apellidoPaterno,apellidoMaterno,
                facultad,correo,contrasenia,disciplina);
        try {
            servicioJuez.agregar(juez);
            model.addAttribute("flagIDNoDisponible", false);
        }catch(IDNodisponibleExcepcion e){
            model.addAttribute("flagIDNoDisponible", true);
        }

        return "AgregarJuezIH";
    }
    /*
    @GetMapping("/editarJuez/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("juez", servicioJuez.buscarPorCuenta(id));
        return "AgregarJuezIH";
    }*/

    @GetMapping("/eliminarJuez/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        servicioJuez.eliminar(id);
        return "redirect:/consultarJuezIH";
    }

    @GetMapping({"/consultarJuezIH","/consultarJuez"})
    public String listarJueces(Model modelo, @Param("busqueda") String busqueda){
        modelo.addAttribute("jueces", getJuecesAMostrar(busqueda));
        return "ConsultarJuezIH";
    }

    // busca por nombre
    private List<Juez> getJuecesAMostrar(String busqueda){
        if(busqueda != null){
            return servicioJuez.buscarPorNombre(busqueda);
        }
        return servicioJuez.obtenerTodos();
    }
}
