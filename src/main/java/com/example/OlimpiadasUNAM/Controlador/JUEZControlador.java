package com.example.OlimpiadasUNAM.Controlador;


import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Modelo.Juez;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioEvento;
import com.example.OlimpiadasUNAM.Servicio.ServicioJuez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.OlimpiadasUNAM.Modelo.Competir;
import com.example.OlimpiadasUNAM.Servicio.ServicioBoleta;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JUEZControlador {

	 @Autowired
	 private ServicioBoleta service;
	 @Autowired
	 private ServicioEvento servicioEvento;
	 @Autowired
	 private ServicioCompetidor servicioCompetidor;
	 @Autowired
	 private ServicioJuez servicioJuez;

	 private Juez juez;

	@RequestMapping("/juez/dashboard")
	public String getJuezDashboard() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String correo = auth.getName();
		this.juez = servicioJuez.buscarPorEmail(correo).get(0);
		return "JuezLandingIH";
	}

	    @GetMapping("/juez/tablaCalificaciones")
	    public String viewHomePage(Model model) {
	        List<Competir> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        return "TablaCalificacionesIH";
	    }

	    @GetMapping("/juez/agregarCalificacion")
	    public String add(Model model, @Param("competidorNumCuenta") Integer competidorNumCuenta, @Param("idEvento") Integer idEvento) {
			Optional<Competir> boleta = service.get(servicioEvento.consultarEvento(idEvento), servicioCompetidor.buscarCompetidor(competidorNumCuenta));
	        if (boleta.isPresent()) {
				model.addAttribute("numCuenta", competidorNumCuenta);
				model.addAttribute("idEvento", idEvento);
				model.addAttribute("puntaje", boleta.get().getPuntaje());
				model.addAttribute("comentarios", boleta.get().getComentarios());
				return "CalificarCompetidoresIH";
			} else {
				return "/juez/ConsultarCompetidoresJuezIH";
			}
	    }

	    @RequestMapping("/juez/guardarCalificacion")
	    public String saveStudent(Model modelo, HttpServletRequest request) {
			Integer idEvento = Integer.valueOf(request.getParameter("idEvento"));
			Integer numCuenta = Integer.valueOf(request.getParameter("numCuenta"));
			Integer puntaje = Integer.valueOf(request.getParameter("puntaje"));
			String comentarios = request.getParameter("comentarios");
			Evento evento = servicioEvento.consultarEvento(idEvento);
			Competidor competidor = servicioCompetidor.buscarCompetidor(numCuenta);
			Optional<Competir> boletaOpcional = service.get(evento,competidor);
			if(boletaOpcional.isPresent()) {
				Competir boleta = boletaOpcional.get();
				boleta.setCompetidor(competidor);
				boleta.setEvento(evento);
				boleta.setPuntaje(puntaje);
				boleta.setComentarios(comentarios);
				service.save(boleta);
				return "redirect:/juez/tablaCalificaciones";
				//return "TablaCalificacionesIH";
			} else {
				// Mostrar algún error
			}
			modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(juez.getDisciplina()));
			return "ConsultarCompetidoresJuezIH";
			//return "TablaCalificacionesIH";
	    }

		/*
	    @RequestMapping("/editar/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("CalificarCompetidoresIH");
	        /*
	        Competir std = service.get(id_____);
	        mav.addObject("student", std);
	        *//*
	        return mav;

	    }*/
		/*
	    @RequestMapping("/eliminar/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	       // service.delete(id);
	        return "redirect:/tablaCalificaciones";
	    }*/

		@RequestMapping("/juez/ConsultarCompetidoresJuezIH")
		public String getConsultarCompetidoresJuez(Model modelo){
			modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(juez.getDisciplina()));
			return "ConsultarCompetidoresJuezIH";
		}

		@GetMapping("/juez/consultarCompetidores")
		public String listarCompetidores(Model modelo, @Param("id_evento") Integer id_evento){
			if (id_evento==null) return "ConsultarCompetidoresJuezIH";
			Evento evento = servicioEvento.consultarEvento(id_evento);
			modelo.addAttribute("evento", evento);
			modelo.addAttribute("competidores", servicioEvento.getCompetidores(evento));
			modelo.addAttribute("listaEventos", servicioEvento.getAllEventos(juez.getDisciplina()));
			return "ConsultarCompetidoresJuezIH";
		}

		@RequestMapping("/juez/menu")
		public String landingJuez(){
			return "JuezLandingIH";
		}
}
