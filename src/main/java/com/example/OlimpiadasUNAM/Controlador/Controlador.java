package com.example.OlimpiadasUNAM.Controlador;

import javax.servlet.http.HttpServletRequest;

import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Servicio.DisciplinaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controlador {

    @Autowired
    private DisciplinaServicio disciplinaServicio;

    /*
     * @RequestMapping("/")
     * public String disciplinaIH(){
     * return "disciplinaIH";
     * }
     */

    @GetMapping("/disciplinaIH")
    public String menuDisciplinas(Model modelo, @Param("busqueda") String busqueda) {
        modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(busqueda));
        modelo.addAttribute("busqueda", busqueda);
        return "disciplinaIH";
    }

    @PostMapping("/agregar")
    public String procesa(HttpServletRequest request, Model modelo, RedirectAttributes redirectAttributes) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNombre(request.getParameter("disciplina"));
        if (disciplinaServicio.existeDisciplina(disciplina.getNombre())) {
            modelo.addAttribute("error", true);
            modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(""));
            return "disciplinaIH";
        } else {
            String auxiliar = disciplina.getNombre();
            auxiliar.trim();
            auxiliar = auxiliar.substring(0, 1).toUpperCase() + auxiliar.substring(1).toLowerCase();
            disciplinaServicio.agregaDisciplina(auxiliar);
            modelo.addAttribute("disciplina", auxiliar);
            redirectAttributes.addFlashAttribute("exitoAgrega", true);
            return "redirect:/disciplinaIH";
        }
    }

    @GetMapping("/disciplinaIH/editar/{id}")
    public String formularioEditar(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("disciplina", disciplinaServicio.consultarDisciplina(id));
        return "formulario";
    }

    @PostMapping("/disciplinaIH/{id}")
    public String actualizarDisciplina(@PathVariable("id") Integer id,
            @ModelAttribute("disciplina") Disciplina disciplina, Model modelo, RedirectAttributes redirectAttributes) {
        Disciplina original = disciplinaServicio.consultarDisciplina(id);
        String nombreOriginal = disciplina.getNombre();
        if (disciplinaServicio.existeDisciplina(nombreOriginal)) {
            modelo.addAttribute("error", true);
            modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(""));
            return "disciplinaIH";
        } else {
            String auxiliar = disciplina.getNombre();
            auxiliar.trim();
            auxiliar.toLowerCase();
            auxiliar = auxiliar.substring(0, 1).toUpperCase() + auxiliar.substring(1);
            original.setNombre(auxiliar);
            disciplinaServicio.editarDisciplina(original);
            redirectAttributes.addFlashAttribute("exitoActualiza", true);
            return "redirect:/disciplinaIH";
        }
    }

    @GetMapping("/disciplinaIH/{id}")
    public String eliminarDisciplina(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model modelo) {
        if (disciplinaServicio.existeDisciplina(disciplinaServicio.consultarDisciplina(id).getNombre())) {
            disciplinaServicio.eliminarDisciplina(id);
            redirectAttributes.addFlashAttribute("exitoElimina", true);
            return "redirect:/disciplinaIH";
        } else {
            modelo.addAttribute("errorElimina", true);
            return "disciplinaIH";
            //No pasaría nunca por aquí por error en el mapping. :>
        }
    }

    //Métodos para menús

    @RequestMapping("/AdministradorLandingIH")
    public String landingAdmin(){
        return "AdministradorLandingIH";
    }

    @RequestMapping("/CompetidorLandingIH")
    public String landingCompetidor(){
        return "CompetidorLandingIH";
    }

    @RequestMapping("/EntrenadorLandingIH")
    public String landingEntrenador(){
        return "EntrenadorLandingIH";
    }

    @RequestMapping("/JuezLandingIH")
    public String landingJuez(){
        return "JuezLandingIH";
    }
    
    //Acciones Juez
    @RequestMapping("/calificarCompetidorIH.html")
    public String calificar(){
        return "calificarCompetidorIH";
    }

}
