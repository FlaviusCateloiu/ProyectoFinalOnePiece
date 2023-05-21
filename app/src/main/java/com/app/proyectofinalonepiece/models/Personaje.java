package com.app.proyectofinalonepiece.models;

public class Personaje {

    private String id;
    private String nombre;
    private String apellido;
    private String descripcion;
    private String raza;
    private String primeraAparicion;
    private boolean jubilado;
    private boolean vivo;
    private int edad;
    private int altura;
    private int diaNacimiento;
    private int mesNacimiento;
    private String idFrutaDelDiablo;
    private String idArma;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRaza() {
        return raza;
    }

    public String getPrimeraAparicion() {
        return primeraAparicion;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public String getIdFrutaDelDiablo() {
        return idFrutaDelDiablo;
    }

    public String getIdArma() {
        return idArma;
    }
}

