package com.autocine.defam.model;

public class Pelicula {
    private String nombre;
    private String imagen;

    // Constructor
    public Pelicula(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }
}
