package com.rolmanager.database;

public class Armas {
    private String nombre;
    private String daño;
    private int numManos;
    private int alcance;
    private int modIniciativa;
    private String efecto;
    private String tipo;

    public Armas(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDaño() {
        return daño;
    }

    public void setDaño(String daño) {
        this.daño = daño;
    }

    public int getNumManos() {
        return numManos;
    }

    public void setNumManos(int numManos) {
        this.numManos = numManos;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getModIniciativa() {
        return modIniciativa;
    }

    public void setModIniciativa(int modIniciativa) {
        this.modIniciativa = modIniciativa;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Armas{" +
                "nombre='" + nombre + '\'' +
                ", daño='" + daño + '\'' +
                ", numManos=" + numManos +
                ", alcance=" + alcance +
                ", modIniciativa=" + modIniciativa +
                ", efecto='" + efecto + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
