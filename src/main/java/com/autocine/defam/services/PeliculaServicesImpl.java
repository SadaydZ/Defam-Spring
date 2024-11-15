package com.autocine.defam.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocine.defam.model.Pelicula;
import com.autocine.defam.repositories.PeliculaRepository;

@Service
public class PeliculaServicesImpl implements IPeliculaService {
        @Autowired
        private final PeliculaRepository peliculaRepository;

        public PeliculaServicesImpl(PeliculaRepository peliculaRepository) {
                this.peliculaRepository = peliculaRepository;
        }

        @Override
        public void agregarPelicula(Pelicula pelicula) {
                peliculaRepository.save(pelicula); // Guarda o actualiza la película en la base de datos
        }

        @Override
        public List<Pelicula> obtenerTodasLasPeliculas() {
                Iterable<Pelicula> peliculasIterable = peliculaRepository.findAll();
                List<Pelicula> peliculas = StreamSupport
                                .stream(peliculasIterable.spliterator(), false)
                                .collect(Collectors.toList());
                return peliculas;
        }

        @Override
        public Pelicula obtenerPeliculaPorTitulo(String titulo) {
                return peliculaRepository.findByTituloIgnoreCase(titulo); // Busca una película por título sin importar
                                                                          // mayúsculas/minúsculas
        }

        @Override
        public void eliminarPelicula(String titulo) {
                Pelicula pelicula = peliculaRepository.findByTituloIgnoreCase(titulo);
                if (pelicula != null) {
                        peliculaRepository.delete(pelicula); // Elimina la película de la base de datos
                }
        }

}
