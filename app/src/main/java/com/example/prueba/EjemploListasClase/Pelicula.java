package com.example.prueba.EjemploListasClase;

import java.util.function.Consumer;

public class Pelicula {

    private Integer id;
    private String nombre;
    private Integer calificacion;
    private Boolean favorita;
    private Genero genero;
    private Integer visualizaciones;

    //CONSTRUCTORES.
    public Pelicula(){

    }
    public Pelicula(Consumer<Pelicula> p){
        p.accept(this);
    }

    public Pelicula(Integer id, String nombre, Integer calificacion, Boolean favorita, Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.favorita = favorita;
        this.genero = genero;
    }

    //GETTERS Y SETTERS.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getFavorita() {
        return favorita;
    }

    public void setFavorita(Boolean favorita) {
        this.favorita = favorita;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(Integer visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    @Override
    public String toString() {
        return "Pelicula: " + nombre;
    }
}
