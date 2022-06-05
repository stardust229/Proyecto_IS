package com.example.OlimpiadasUNAM.Modelo;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario {
    @Id
    @Column(name = "numcuenta")
    private int numcuenta;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String facultad;
    private String correo;
    private String contrasenia;

    public Usuario(int numcuenta,
                   String nombre,
                   String apellidoPaterno,
                   String apellidoMaterno,
                   String facultad,
                   String correo,
                   String contrasenia) {
        this.numcuenta = numcuenta;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.facultad = facultad;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Usuario(){
        return;
    }

    public int getNumCuenta() {

        return numcuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numcuenta = numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "numCuenta=" + numcuenta +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", facultad='" + facultad + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
