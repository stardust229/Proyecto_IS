package com.example.OlimpiadasUNAM.Repositorio;
import com.example.OlimpiadasUNAM.Modelo.Entrenador;
import javax.transaction.Transactional;

@Transactional
public interface EntrenadorAdmiRepositorio extends UsuarioRepositorio<Entrenador> {

}