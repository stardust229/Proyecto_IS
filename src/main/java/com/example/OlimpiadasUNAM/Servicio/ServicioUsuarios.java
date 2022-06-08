package com.example.OlimpiadasUNAM.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para verificar si hay usuarios ya registrados con alguna dirección de correo o co cierto número de cuenta.
 * Esto de debe consultar siempre que se quiera registrar un usuario nuevo.
 */
@Service
public class ServicioUsuarios {

    @Autowired
    private ServicioAdministrador servicioAdministrador;
    @Autowired
    private ServicioEntrenador servicioEntrenador;
    @Autowired
    private ServicioJuez servicioJuez;
    @Autowired
    private ServicioCompetidor servicioCompetidor;

    /**
     * Busca en todos los usuarios a ver si hay alguno con el correo especificado.
     * @param correo
     * @return True si ya hay un usuario registrado con ese correo. False si no.
     */
    public boolean existeUsuario(String correo){
        if (servicioAdministrador.buscarPorEmail(correo) != null) return true;
        if (servicioEntrenador.buscarPorEmail(correo) != null) return true;
        if (servicioJuez.buscarPorEmail(correo).size() > 0 ) return true;
        if (servicioCompetidor.buscarCompetidor(correo) != null) return true;
        return false;
    }

    /**
     * Busca en todos los usuarios a ver si hay alguno con el número de cuenta especificado.
     * @param numCuenta
     * @return True si ya hay un usuario registrado con ese número de cuenta. False si no.
     */
    public boolean existeUsuario(int numCuenta){
        if (servicioAdministrador.buscarPorNumCuenta(numCuenta).isPresent()) return true;
        if (servicioEntrenador.buscarPorNumCuenta(numCuenta).isPresent()) return true;
        if (servicioJuez.buscarPorCuenta(numCuenta).isPresent()) return true;
        if (servicioCompetidor.buscarCompetidor(numCuenta) != null ) return true;
        return false;
    }

}
