package com.rolmanager.database;

public class Personajes {
    private String nombre;
    private String nombreJugador;
    private String especie;
    private int edad;
    private double altura;
    private String sexo;
    private int nivel;
    private String clase;
    private int id;

    public Personajes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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
                ", clase='" + clase + '\'' +
                ", id=" + id +
                '}';
    }
}
