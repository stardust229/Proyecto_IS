package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.JuezBuilder;
import com.example.OlimpiadasUNAM.Servicio.DisciplinaServicio;
import com.example.OlimpiadasUNAM.Servicio.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.example.OlimpiadasUNAM.Modelo.Juez;
import com.example.OlimpiadasUNAM.Servicio.IDNodisponibleExcepcion;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;

import java.util.List;
import java.util.Optional;

@Controller
public class ADMINControladorJuez {

    @Autowired
    private ServicioJuez servicioJuez;
    @Autowired
    private DisciplinaServicio disciplinaServicio;
    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping("/agregarJuezIH")
    public String agregarJuezIH(){
        return "AgregarJuezIH";
    }

    @RequestMapping("/consultarJuezIH")
    public String consultarJuezIH(){
        return "ConsultarJuezIH";
    }

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
        String disciplina_nombre = request.getParameter("disciplina");

        String contrasenia = "random"; // la contra se debe generar de forma random

        if(servicioUsuarios.existeUsuario(numCuenta)){
            model.addAttribute("flagIDNoDisponible", true);
            return "AgregarJuezIH";
        }
        if(servicioUsuarios.existeUsuario(correo)) {
            model.addAttribute("flagEmailNoDisponible", true);
            return "AgregarJuezIH";
        }
        List<Disciplina> disciplinaList = disciplinaServicio.mostrarDisciplinas(disciplina_nombre);
        if(disciplinaList.size() <1){ //la disciplina no existe
            model.addAttribute("flagDisciplinaNoExiste", true);
        }else {
            Disciplina disciplina = disciplinaList.get(0);
            Juez juez = new Juez(numCuenta,nombre,apellidoPaterno,apellidoMaterno,
                    facultad,correo,contrasenia,disciplina);
            try {
                servicioJuez.agregar(juez);
                model.addAttribute("exitoAgrega", true);
            } catch (IDNodisponibleExcepcion e) {
                model.addAttribute("flagIDNoDisponible", true);
            }
        }
        return "AgregarJuezIH";
    }

    @GetMapping("/editarJuez/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        Juez juez = servicioJuez.buscarPorCuenta(id).get();
        JuezBuilder juezBuilder = new JuezBuilder(juez.getDisciplina().getNombre(),
                juez.getNumCuenta(), juez.getNombre(), juez.getApellidoPaterno(), juez.getApellidoMaterno(),
                juez.getFacultad(), juez.getCorreo(), juez.getContrasenia());
        model.addAttribute("juezBuilder", juezBuilder);
        return "EditarJuezIH";
    }

    @PostMapping("/actualizarJuez")
    public String actualizarJuez(@ModelAttribute JuezBuilder juezBuilder, Model modelo) {
        int numCuenta = juezBuilder.getNumCuenta();
        String nombre = juezBuilder.getNombre();
        String apellidoPaterno = juezBuilder.getApellidoPaterno();
        String apellidoMaterno = juezBuilder.getApellidoMaterno();
        String facultad = juezBuilder.getFacultad();
        String correo = juezBuilder.getCorreo();
        String disciplina_nombre = juezBuilder.getDisciplina();
        List<Disciplina> disciplinaList = disciplinaServicio.mostrarDisciplinas(disciplina_nombre);
        Optional<Juez> juezOriginal = servicioJuez.buscarPorCuenta(numCuenta);

        modelo.addAttribute("juezBuilder", juezBuilder);
        if (!juezOriginal.isPresent()) {
            modelo.addAttribute("error", true);
            return "EditarJuezIH";
        }
        Juez juez = juezOriginal.get();

        if(!juez.getCorreo().equals(correo) &&  servicioUsuarios.existeUsuario(correo)) {
            modelo.addAttribute("flagEmailNoDisponible", true);
        } else {
            if(disciplinaList.size() <1){ //la disciplina no existe
                modelo.addAttribute("flagDisciplinaNoExiste", true);
            }else {
                Disciplina disciplina = disciplinaList.get(0);
                juez.setNombre(nombre);
                juez.setApellidoPaterno(apellidoPaterno);
                juez.setApellidoMaterno(apellidoMaterno);
                juez.setFacultad(facultad);
                juez.setCorreo(correo);
                System.out.println(disciplina);
                juez.setDisciplina(disciplina);
                try {
                    servicioJuez.editar(juez);
                    modelo.addAttribute("exitoActualiza", true);
                    return "EditarJuezIH";
                }catch(Exception e){
                    modelo.addAttribute("error", true);
                }
            }
        }
        return "EditarJuezIH";
    }

    @GetMapping("/eliminarJuez/{id}")
    public String eliminar(@PathVariable("id") Integer id, Model model){
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