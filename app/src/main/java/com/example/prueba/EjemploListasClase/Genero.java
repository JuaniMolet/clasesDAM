package com.example.prueba.EjemploListasClase;

import java.util.function.Consumer;

public class Genero {
    private Integer id;
    private String descripcion;

    public Genero(){
    }

    public Genero(Consumer<Genero> g){
        g.accept(this);
    }

    public Genero(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
