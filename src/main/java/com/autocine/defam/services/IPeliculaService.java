package com.autocine.defam.services;

import java.util.List;

import com.autocine.defam.model.Pelicula;

public interface IPeliculaService {
    void agregarPelicula(Pelicula pelicula);

    List<Pelicula> obtenerTodasLasPeliculas();

    Pelicula obtenerPeliculaPorTitulo(String titulo);

    void eliminarPelicula(String titulo);

}
