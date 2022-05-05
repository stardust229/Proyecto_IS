package com.example.OlimpiadasUNAM.servicio;
import com.example.OlimpiadasUNAM.modelo.ModeloUsuario;
import com.example.OlimpiadasUNAM.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public ServicioUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public ModeloUsuario registrarUsuario(String nombre, String email, String password){
        if(nombre == null || email == null || password == null){
            return null;
        }else{
            if(usuarioRepositorio.findFirstByEmail(email).isPresent()){
                System.out.println("Email Duplicado");
                return null;
            }
            ModeloUsuario modeloUsuario = new ModeloUsuario();
            modeloUsuario.setNombre(nombre);
            modeloUsuario.setEmail(email);
            modeloUsuario.setPassword(password);
            return usuarioRepositorio.save(modeloUsuario);
        }
    }

    public ModeloUsuario autenticar(String email, String password){
        return usuarioRepositorio.findByEmailAndPassword(email,password).orElse(null);
    }
}
