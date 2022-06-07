package com.example.OlimpiadasUNAM.Controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.OlimpiadasUNAM.Modelo.Boleta;
import com.example.OlimpiadasUNAM.Servicio.ServicioBoleta;

@Controller
public class JUEZControlador {

	 @Autowired
	    private ServicioBoleta service;

	    @GetMapping("/tablaCalificaciones")
	    public String viewHomePage(Model model) {
	        List<Boleta> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        return "TablaCalificacionesIH";
	    }

	    @GetMapping("/agregarCalificacion")
	    public String add(Model model) {
	        model.addAttribute("student", new Boleta());
	        return "CalificarCompetidoresIH";
	    }

	    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") Boleta std) {
	        service.save(std);
	        return "redirect:/tablaCalificaciones";
	    }

	    @RequestMapping("/editar/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("CalificarCompetidoresIH");
	        Boleta std = service.get(id);
	        mav.addObject("student", std);
	        return mav;

	    }
	    @RequestMapping("/eliminar/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/tablaCalificaciones";
	    }

		@RequestMapping("/JuezLandingIH")
		public String landingJuez(){
			return "JuezLandingIH";
		}
}
