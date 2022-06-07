package com.example.OlimpiadasUNAM.Controlador;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Servicio.DisciplinaServicio;
import com.example.OlimpiadasUNAM.Servicio.ServicioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControladorEvento {

    @Autowired
    private ServicioEvento eventoServicio;
    @Autowired
    private DisciplinaServicio disciplinaServicio;

    @GetMapping("/disciplinaIH/{id}/EventoIH")
    public String verEventos(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("evento", eventoServicio.mostrarEventos(id));
        modelo.addAttribute("disciplinaOriginal", disciplinaServicio.consultarDisciplina(id).getId());
        modelo.addAttribute("nombreDisciplina", disciplinaServicio.consultarDisciplina(id).getNombre());
        return "EventoIH";
    }

    @PostMapping("/agregarEvento/{id}")
    public String agregarEvento(@PathVariable("id") Integer id, HttpServletRequest request, Model modelo,
            RedirectAttributes redirectAttributes) throws ParseException {
        Evento evento = new Evento();
        evento.setDisciplina(disciplinaServicio.consultarDisciplina(id));
        evento.setNombre(request.getParameter("nombre").toLowerCase());
        if (eventoServicio.existeEvento(evento.getNombre(), id)) { // eventoServicio.existeEvento(evento.getNombre(),
                                                                   // evento.getDisciplina())
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("evento", eventoServicio.mostrarEventos(id));
            return "redirect:/disciplinaIH/" + id + "/EventoIH";
        } else {
            evento.setDescripcion(request.getParameter("descripcion").toLowerCase());
            DateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            Date fecha = formato.parse(request.getParameter("fecha"));
            evento.setFecha(fecha);
            eventoServicio.agregarEvento(evento);
            modelo.addAttribute("evento", evento);
            redirectAttributes.addFlashAttribute("exitoAgrega", true);
            return "redirect:/disciplinaIH/" + id + "/EventoIH";
        }
    }

    @GetMapping("/disciplinaIH/{idDisciplina}/EventoIH/{id}")
    public String eliminarEvento(@PathVariable("id") Integer id, @PathVariable("idDisciplina") Integer idDisciplina,
            RedirectAttributes redirectAttributes, Model modelo) {
        modelo.addAttribute("disciplinaOriginal", disciplinaServicio.consultarDisciplina(idDisciplina).getId());
        Integer idEvento = Integer.valueOf(id);
        if (eventoServicio.consultarEvento(idEvento) != null) {
            eventoServicio.eliminarEvento(idEvento);
            redirectAttributes.addFlashAttribute("exitoElimina", true);
            return "redirect:/disciplinaIH/" + idDisciplina + "/EventoIH";
        } else {
            modelo.addAttribute("errorElimina", true);
            return "disciplinaIH/" + idDisciplina + "/EventoIH";
        }
    }

    @GetMapping("/disciplinaIH/{idDisciplina}/EventoIH/editar/{id}")
    public String formularioEditarEvento(@PathVariable("id") Integer id, @PathVariable("idDisciplina") Integer idDisciplina, Model modelo) {
        modelo.addAttribute("evento", eventoServicio.consultarEvento(id));
        modelo.addAttribute("disciplinaOriginal", eventoServicio.consultarEvento(id).getDisciplina().getId());
        //modelo.addAttribute("disciplinaOriginal", disciplinaServicio.consultarDisciplina(idDisciplina));
        return "FormularioEvento";
    }

    @PostMapping("/editar/{idDisciplina}/{id}")
    public String editarEvento(@PathVariable("id") Integer id, @ModelAttribute("disciplina") Evento evento, Model modelo,
            RedirectAttributes redirectAttributes, @PathVariable("idDisciplina") Integer idDisciplina) throws ParseException {
        Evento original = eventoServicio.consultarEvento(id);
        String nombre = evento.getNombre();
        String descripcion = evento.getDescripcion();
        Date fecha = evento.getFecha();
        if (eventoServicio.existeEvento(nombre, idDisciplina) && !nombre.equalsIgnoreCase(original.getNombre())) {
            redirectAttributes.addFlashAttribute("error", true);
            redirectAttributes.addFlashAttribute("evento", eventoServicio.mostrarEventos(idDisciplina));
            return "redirect:/disciplinaIH/" + idDisciplina + "/EventoIH";
        } else {
            original.setNombre(nombre.toLowerCase());
            original.setDescripcion(descripcion.toLowerCase());
            original.setFecha(fecha);
            eventoServicio.editaEvento(original); 
            redirectAttributes.addFlashAttribute("exitoActualiza", true);
            return "redirect:/disciplinaIH/" + idDisciplina + "/EventoIH";
        }
    }
}
