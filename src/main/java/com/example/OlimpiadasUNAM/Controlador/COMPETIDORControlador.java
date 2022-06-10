package com.example.OlimpiadasUNAM.Controlador;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Modelo.Disciplina;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class COMPETIDORControlador {
    @Autowired
    ServicioBoleta service;
    @Autowired
    DisciplinaServicio disciplinaServicio;
    @Autowired
    ServicioEvento servicioEvento;
    @Autowired
    ServicioCompetidor serv;
    @Autowired
    ServicioCompetir comp;

     Competidor competidor;
    /* @RequestMapping("/CompetidorLandingIH")
    public String landingCompetidor(){

        return "CompetidorLandingIH";
    }*/
    @RequestMapping("/competidor/dashboard")
    public String getCompetidorDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.competidor = serv.buscarCompetidor(correo);
        return "CompetidorLandingIH";

    }

    @GetMapping("/competidor/retroalimentacion")
    public String retroalimentacion(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String correo = auth.getName();
        this.competidor = serv.buscarCompetidor(correo);
        int numCuenta = competidor.getNumCuenta();
        model.addAttribute("competencias",comp.obtenerCompetencias(numCuenta));
        return "RetroalimentacionIH";
    }

    /*
    @GetMapping("/posiciones")
    public String viewHomePage(Model model) {
        List<Competir> liststudent = service.listAll();

        model.addAttribute("liststudent", liststudent);
        return "TablaPosicionesIH";
    }*/

    @RequestMapping("/competidor/posiciones")
    public String competidorGetTablaPosicionesIH(Model modelo){
        List<Disciplina> disciplinas = disciplinaServicio.mostrarDisciplinas(null);
        modelo.addAttribute("id_disciplinaSeleccionada", 1);
        modelo.addAttribute("listaDisciplinas", disciplinas);
        return "TablaPosicionesIH";
    }

    @GetMapping("/competidor/getEventosDeDisciplina")
    public String competidorGetEventos(Model modelo, @Param("id_disciplina") Integer id_disciplina){
        if (id_disciplina==null) {
            List<Disciplina> disciplinas = disciplinaServicio.mostrarDisciplinas(null);
            modelo.addAttribute("id_disciplinaSeleccionada", 1);
            modelo.addAttribute("listaDisciplinas", disciplinas);
            return "TablaPosicionesIH";
        }
        Disciplina disc = disciplinaServicio.consultarDisciplina(id_disciplina);
        List<Evento> listaEventos = servicioEvento.getAllEventos(disc);
        modelo.addAttribute("id_disciplinaSeleccionada", id_disciplina);
        modelo.addAttribute("id_eventoSeleccionado",listaEventos.size()>0 ? listaEventos.get(0).getIdEvento(): 0);
        modelo.addAttribute("listaDisciplinas", disciplinaServicio.mostrarDisciplinas(null));
        modelo.addAttribute("listaEventos", listaEventos);
        return "TablaPosicionesIH";
    }

    @GetMapping("/competidor/consultarCalificaciones")
    public String competidorListarCalificaciones(Model modelo, @Param("id_evento") Integer id_evento){
        if (id_evento==null) {
            List<Disciplina> disciplinas = disciplinaServicio.mostrarDisciplinas(null);
            modelo.addAttribute("id_disciplinaSeleccionada", 1);
            modelo.addAttribute("listaDisciplinas", disciplinas);
            return "TablaPosicionesIH";
        }
        Evento evento = servicioEvento.consultarEvento(id_evento);
        modelo.addAttribute("evento", evento);
        modelo.addAttribute("id_disciplinaSeleccionada", evento.getDisciplina().getId());
        modelo.addAttribute("id_eventoSeleccionado",id_evento);
        modelo.addAttribute("listaDisciplinas", disciplinaServicio.mostrarDisciplinas(null));
        modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(evento.getDisciplina()));
        modelo.addAttribute("listaCalificaciones", service.getTodosPorEventoOrdenDescendiente(evento));
        modelo.addAttribute("hayEventoSeleccionado", true);
        return "TablaPosicionesIH";
    }

}
