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
public class ADMINControladorDisciplina {

    @Autowired
    private DisciplinaServicio disciplinaServicio;


    @RequestMapping("/admin/disciplinaIH")
    public String disciplinaIH(Model modelo, @Param("busqueda") String busqueda){
        //modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(busqueda));
        //modelo.addAttribute("busqueda", busqueda);
        return "disciplinaIH";
    }
    
    @GetMapping("/admin/disciplinaIH")
    public String menuDisciplinas(Model modelo, @Param("busqueda") String busqueda) {
        modelo.addAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(busqueda));
        modelo.addAttribute("busqueda", busqueda);
        return "disciplinaIH";
    }


    @PostMapping("/admin/agregar")
    public String procesa(HttpServletRequest request, Model modelo, RedirectAttributes redirectAttributes) {
        Disciplina disciplina = new Disciplina();
        String nombreD = request.getParameter("disciplina").toLowerCase();
        disciplina.setNombre(nombreD);
        if (disciplinaServicio.existeDisciplina(disciplina.getNombre())) {
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(""));
            //redirectAttributes.addibute("disciplina", disciplinaServicio.mostrarDisciplinas(""));
            return "redirect:/admin/disciplinaIH";
        } else {
            //String auxiliar = disciplina.getNombre();
            //auxiliar.trim();
            //auxiliar = auxiliar.substring(0, 1).toUpperCase() + auxiliar.substring(1).toLowerCase();
            disciplinaServicio.agregaDisciplina(nombreD);
            redirectAttributes.addFlashAttribute("disciplina", nombreD);
            redirectAttributes.addFlashAttribute("exitoAgrega", true);
            return "redirect:/admin/disciplinaIH";
        }
    }

    @GetMapping("/admin/disciplinaIH/editar/{id}")
    public String formularioEditar(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("disciplina", disciplinaServicio.consultarDisciplina(id));
        return "formulario";
    }
 
    @PostMapping("/admin/disciplinaIH/{id}")
    public String actualizarDisciplina(@PathVariable("id") Integer id,
            @ModelAttribute("disciplina") Disciplina disciplina, Model modelo, RedirectAttributes redirectAttributes) {
        Disciplina original = disciplinaServicio.consultarDisciplina(id);
        String nombreOriginal = disciplina.getNombre();
        if (disciplinaServicio.existeDisciplina(nombreOriginal)) {
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("disciplina", disciplinaServicio.mostrarDisciplinas(""));
            return "redirect:/admin/disciplinaIH";
        } else {
            //String auxiliar = disciplina.getNombre();
            //auxiliar.trim();
            //auxiliar.toLowerCase();
            //auxiliar = auxiliar.substring(0, 1).toUpperCase() + auxiliar.substring(1);
            original.setNombre(disciplina.getNombre().toLowerCase());
            disciplinaServicio.editarDisciplina(original);
            redirectAttributes.addFlashAttribute("exitoActualiza", true);
            return "redirect:/admin/disciplinaIH";
        }
    }

    @GetMapping("/admin/disciplinaIH/{id}")
    public String eliminarDisciplina(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model modelo) {
        if (disciplinaServicio.existeDisciplina(disciplinaServicio.consultarDisciplina(id).getNombre())) {
            disciplinaServicio.eliminarDisciplina(id);
            redirectAttributes.addFlashAttribute("exitoElimina", true);
            return "redirect:/admin/disciplinaIH";
        } else {
            modelo.addAttribute("errorElimina", true);
            return "/admin/disciplinaIH";
            //No pasar??a nunca por aqu?? por error en el mapping. :>
        }
    }

    //M??todos para men??s

    @RequestMapping("/admin/AdministradorLandingIH")
    public String landingAdmin(){
        return "AdministradorLandingIH";
    }

}
