package com.example.OlimpiadasUNAM.repositorio;

import com.example.OlimpiadasUNAM.modelo.ModeloUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<ModeloUsuario, Integer> {

    Optional<ModeloUsuario> findByEmailAndPassword(String email, String password);

    Optional<ModeloUsuario> findFirstByEmail(String email);

}
