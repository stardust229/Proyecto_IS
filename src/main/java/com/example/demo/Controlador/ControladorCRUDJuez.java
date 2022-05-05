package com.example.demo.Controlador;

import com.example.demo.Modelo.Juez;
import com.example.demo.Servicio.IDNodisponibleExcepcion;
import com.example.demo.Servicio.ServicioJuez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("consultarJuez/editarJuez/{id}")
    public String editar(@PathVariable String id, Model model){
        int numCuenta = Integer.parseInt(id);
        model.addAttribute("sss", numCuenta);
        System.out.println(numCuenta);
        return "AgregarJuezIH";
    }
/*
    @PostMapping("/consultarJuez")
    public void buscar(HttpServletRequest request, Model model){
        String campo = request.getParameter("campo");
        String valor = request.getParameter("valor");
        switch (campo){
            case "numCuenta":
                servicioJuez.buscarPorCuenta(Integer.parseInt(valor));
        }
    }*/

    @GetMapping("/consultarJuez")
    public String listarJueces(Model modelo){
        modelo.addAttribute("jueces", servicioJuez.obtenerTodos());
        return "ConsultarJuezIH";
    }
}
