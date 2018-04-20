package com.rolmanager.database;

public class Especies {

    private String nombre;
    private int edadAdulta;
    private int edadMedia;
    private int pesoMinimo;
    private int pesoMaximo;
    private double alturaMinima;
    private double alturaMaxima;
    private String aspectos;
    private String relacion;
    private int imagen;


    public Especies(){}

    public Especies(String nombre, int edadMedia, int edadAdulta, int pesoMinimo, int pesoMaximo, double alturaMinima, double alturaMaxima, String aspectos, String relacion, int imagen) {
        this.nombre = nombre;
        this.edadAdulta = edadAdulta;
        this.edadMedia = edadMedia;
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
        this.alturaMinima = alturaMinima;
        this.alturaMaxima = alturaMaxima;
        this.aspectos = aspectos;
        this.relacion = relacion;
        this.imagen=imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadAdulta() {
        return edadAdulta;
    }

    public void setEdadAdulta(int edadAdulta) {
        this.edadAdulta = edadAdulta;
    }

    public int getEdadMedia() {
        return edadMedia;
    }

    public void setEdadMedia(int edadMedia) {
        this.edadMedia = edadMedia;
    }

    public int getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(int pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public double getAlturaMinima() {
        return alturaMinima;
    }

    public void setAlturaMinima(double alturaMinima) {
        this.alturaMinima = alturaMinima;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public String getAspectos() {
        return aspectos;
    }

    public void setAspectos(String aspectos) {
        this.aspectos = aspectos;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Especies{" +
                "nombre='" + nombre + '\'' +
                ", edadAdulta=" + edadAdulta +
                ", edadMedia=" + edadMedia +
                ", pesoMinimo=" + pesoMinimo +
                ", pesoMaximo=" + pesoMaximo +
                ", alturaMinima=" + alturaMinima +
                ", alturaMaxima=" + alturaMaxima +
                ", aspectos='" + aspectos + '\'' +
                ", relacion='" + relacion + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
