package com.rolmanager.database;

public class Personajes {
    private String nombre;
    private String nombreJugador;
    private String especie;
    private int edad;
    private int altura;
    private String sexo;
    private int nivel;

    public Personajes(){}

    public Personajes(String nombre, String nombreJugador, String especie, int edad, int altura, String sexo, int nivel) {
        this.nombre = nombre;
        this.nombreJugador = nombreJugador;
        this.especie = especie;
        this.edad = edad;
        this.altura = altura;
        this.sexo = sexo;
        this.nivel=nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "nombre='" + nombre + '\'' +
                ", nombreJugador='" + nombreJugador + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", sexo='" + sexo + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
