package com.example.OlimpiadasUNAM.Controlador;


import java.util.List;
import java.util.Optional;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Evento;
import com.example.OlimpiadasUNAM.Servicio.ServicioCompetidor;
import com.example.OlimpiadasUNAM.Servicio.ServicioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	    @GetMapping("/tablaCalificaciones")
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

	    @PostMapping("/guardar")
	    public String saveStudent(Model modelo, HttpServletRequest request) {
			Integer idEvento = Integer.valueOf(request.getParameter("idEvento"));
			Integer numCuenta = Integer.valueOf(request.getParameter("numCuenta"));
			Integer puntaje = Integer.valueOf(request.getParameter("puntaje"));
			String comentarios = request.getParameter("comentarios");
			Evento evento = servicioEvento.consultarEvento(idEvento);
			Competidor competidor = servicioCompetidor.buscarCompetidor(numCuenta);
			Competir boleta = new Competir(evento, competidor, puntaje, comentarios);
			// el problema está aquí:
	        service.save(boleta);
	        return "redirect:/tablaCalificaciones";
	    }


	    @RequestMapping("/editar/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("CalificarCompetidoresIH");
	        /*
	        Competir std = service.get(id_____);
	        mav.addObject("student", std);
	        */
	        return mav;

	    }
	    @RequestMapping("/eliminar/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	       // service.delete(id);
	        return "redirect:/tablaCalificaciones";
	    }

		@RequestMapping("/juez/ConsultarCompetidoresJuezIH")
		public String getConsultarComeptidoresJuez(Model modelo){
			modelo.addAttribute("listaEventos", servicioEvento.getAllEventos());
			return "ConsultarCompetidoresJuezIH";
		}

		@GetMapping("/juez/consultarCompetidores")
		public String listarCompetidores(Model modelo, @Param("id_evento") Integer id_evento){
			if (id_evento==null) return "ConsultarJuezIH";
			Evento evento = servicioEvento.consultarEvento(id_evento);
			modelo.addAttribute("evento", evento);
			modelo.addAttribute("competidores", servicioEvento.getCompetidores(evento));
			modelo.addAttribute("listaEventos", servicioEvento.getAllEventos());
			return "ConsultarCompetidoresJuezIH";
		}

		@RequestMapping("/JuezLandingIH")
		public String landingJuez(){
			return "JuezLandingIH";
		}
}
