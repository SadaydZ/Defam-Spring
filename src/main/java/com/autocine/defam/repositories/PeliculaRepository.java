package com.autocine.defam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autocine.defam.model.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
    Pelicula findByTituloIgnoreCase(String titulo); // Método personalizado para buscar por título

}
