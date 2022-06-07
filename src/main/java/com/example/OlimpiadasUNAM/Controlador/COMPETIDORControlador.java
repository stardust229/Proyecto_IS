package com.example.OlimpiadasUNAM.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class COMPETIDORControlador {

    @RequestMapping("/CompetidorLandingIH")
    public String landingCompetidor(){
        return "CompetidorLandingIH";
    }
}
