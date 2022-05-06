package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Administrador;

import javax.transaction.Transactional;

@Transactional
public interface AdministradorRepositorio extends UsuarioRepositorio<Administrador> {
}
