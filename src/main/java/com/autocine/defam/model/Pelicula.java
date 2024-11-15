package com.autocine.defam.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private int duracion; // en minutos
    private String genero;
    private int anio;
    @Column(name = "imagenUrl")
    private String imagenUrl;
    private String resumen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaEstreno")
    private Date fechaEstreno;

    public Pelicula() {
        // Este constructor puede estar vacío, JPA lo necesita para instanciar objetos
    }

    public Pelicula(Integer id, String titulo, int duracion, String genero, int anio, String imagenUrl,
            String resumen, Date fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.anio = anio;
        this.imagenUrl = imagenUrl;
        this.resumen = resumen;
        this.fechaEstreno = fechaEstreno;
    }

    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }
}
