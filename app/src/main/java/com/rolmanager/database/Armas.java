package com.rolmanager.database;

public class Armas {
    private String nombre;
    private String dano;
    private int numManos;
    private int alcance;
    private int modIniciativa;
    private String efecto;

    public Armas(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
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

    @Override
    public String toString() {
        return "Armas{" +
                "nombre='" + nombre + '\'' +
                ", dano='" + dano + '\'' +
                ", numManos=" + numManos +
                ", alcance=" + alcance +
                ", modIniciativa=" + modIniciativa +
                ", efecto='" + efecto + '\'' +
                '}';
    }
}
