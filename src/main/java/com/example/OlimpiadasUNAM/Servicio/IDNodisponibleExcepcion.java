package com.example.OlimpiadasUNAM.Servicio;

/**
 * Excepción para cuando se trata de agregar a una tabla un registro
 * con una id que ya existe.
 */
public class IDNodisponibleExcepcion extends Exception{
    public IDNodisponibleExcepcion(String message) {
        super(message);
    }
}
