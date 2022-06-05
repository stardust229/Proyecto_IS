package com.example.OlimpiadasUNAM.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;
import com.example.OlimpiadasUNAM.Modelo.Usuario;

@NoRepositoryBean
public interface UsuarioRepositorio <T extends Usuario> extends JpaRepository<T, Integer> {
    List<T> findByNombre(String nombre);
    List<T> findByApellidoPaterno(String apellido);
    List<T> findByApellidoMaterno(String apellido);
    List<T> findByCorreo(String correo);
    List<T> findByFacultad(String facultad);
}
