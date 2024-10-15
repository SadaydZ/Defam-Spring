package com.autocine.defam.model;

import java.util.Date;

public class Pelicula {
    private String titulo;
    private int duracion; // en minutos
    private String genero;
    private int anio;
    private String imagenUrl;
    private String resumen;
    private Date fechaEstreno;

    public Pelicula(String titulo, int duracion, String genero, int anio, String imagenUrl,
            String resumen, Date fechaEstreno) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.anio = anio;
        this.imagenUrl = imagenUrl;
        this.resumen = resumen;
        this.fechaEstreno = fechaEstreno;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                ", anio=" + anio +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", resumen='" + resumen + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                '}';
    }
}
