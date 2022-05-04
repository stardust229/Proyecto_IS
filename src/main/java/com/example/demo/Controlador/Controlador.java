package com.example.demo.Controlador;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Modelo.Disciplina;
import com.example.demo.Repositorio.DisciplinaRepositorio;
import com.example.demo.Servicio.DisciplinaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador{

    @Autowired
    private DisciplinaServicio disciplinaServicio;

    /*
    @RequestMapping("/")
    public String disciplinaIH(){
        return "disciplinaIH";
    }
    */

    @GetMapping({"/disciplinaIH", "/"})
    public String menuDisciplinas(Model modelo, @Param("busqueda") String busqueda){
        modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(busqueda));
        modelo.addAttribute("busqueda", busqueda);
        return "disciplinaIH";
    }

    @PostMapping("/agregar")
    public String procesa(HttpServletRequest request, Model modelo){
        Disciplina disciplina = disciplinaServicio.agregaDisciplina(request.getParameter("disciplina"));
        modelo.addAttribute("disciplina", disciplina);
        return "redirect:/disciplinaIH";
    }

    @GetMapping("/disciplinaIH/editar/{id}")
    public String formularioEditar(@PathVariable("id") Integer id, Model modelo){
        modelo.addAttribute("disciplina", disciplinaServicio.consultarDisciplina(id));
        return "formulario";
    }

    @PostMapping("/disciplinaIH/{id}")
    public String actualizarDisciplina(@PathVariable("id") Integer id, @ModelAttribute("disciplina") Disciplina disciplina, Model modelo){
        Disciplina original = disciplinaServicio.consultarDisciplina(id);
        original.setNombre(disciplina.getNombre());
        disciplinaServicio.editarDisciplina(original);
        return "redirect:/disciplinaIH";
    }

    @GetMapping("/disciplinaIH/{id}")
    public String eliminarDisciplina(@PathVariable Integer id){
        disciplinaServicio.eliminarDisciplina(id);
        return "redirect:/disciplinaIH";
    }
    
}