package com.rolmanager.database;

public class Armaduras {
    private String nombre;
    private int ca;
    private int penalizacion;
    private String tipo;

    public Armaduras(){}

    public Armaduras(String nombre, int ca, int pen, String tipo){
        this.nombre=nombre;
        this.ca=ca;
        this.penalizacion=pen;
        this.tipo=tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Armaduras{" +
                "nombre='" + nombre + '\'' +
                ", ca=" + ca +
                ", penalizacion=" + penalizacion +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
