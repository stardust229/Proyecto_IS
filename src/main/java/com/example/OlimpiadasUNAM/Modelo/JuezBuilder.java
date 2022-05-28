package com.example.OlimpiadasUNAM.Modelo;

import javax.persistence.ManyToOne;

public class JuezBuilder {
    private String disciplina;
    private int numCuenta;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String facultad;
    private String correo;
    private String contrasenia;

    public JuezBuilder(String disciplina, int numCuenta, String nombre, String apellidoPaterno,
                       String apellidoMaterno, String facultad, String correo, String contrasenia) {
        this.disciplina = disciplina;
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.facultad = facultad;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "JuezBuilder{" +
                "disciplina='" + disciplina + '\'' +
                ", numCuenta=" + numCuenta +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", facultad='" + facultad + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
