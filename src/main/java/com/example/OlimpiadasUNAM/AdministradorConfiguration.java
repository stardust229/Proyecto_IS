package com.example.OlimpiadasUNAM;

import com.example.OlimpiadasUNAM.Modelo.Administrador;
import com.example.OlimpiadasUNAM.Repositorio.AdministradorRepositorio;
import com.example.OlimpiadasUNAM.Servicio.ServicioAdministrador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * En esta clase se especifican los administradores que están registrados desde el inicio.
 */
@Configuration
public class AdministradorConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(AdministradorRepositorio administradorRepositorio){
        return args -> {
            Administrador admin1 = new Administrador(
                    1,"Juan","Pérez","López",
                    "Facultad de Ciencias","usuario@gmail.com","1234"
            );

            administradorRepositorio.save(admin1);
        };
    }
}
