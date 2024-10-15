package com.autocine.defam.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.autocine.defam.model.Pelicula; // Importa la clase Pelicula

@Controller
public class PeliculaController {

    @GetMapping("/peliculas")
    public String peliculas(Model model) {
        // lista de películas para recomendaciones
        List<Pelicula> recomendaciones = new ArrayList<>();
        recomendaciones.add(new Pelicula("Avengers: Endgame", "/images/foto.png"));
        recomendaciones.add(new Pelicula("The Lion King", "/images/foto.png"));
        recomendaciones.add(new Pelicula("Toy Story 4", "/images/foto.png"));
        recomendaciones.add(new Pelicula("Joker", "/images/foto.png"));

        // lista de próximos estrenos
        List<Pelicula> proximosEstrenos = new ArrayList<>();
        proximosEstrenos.add(new Pelicula("Dune", "/images/foto.png"));
        proximosEstrenos.add(new Pelicula("No Time to Die", "/images/foto.png"));
        proximosEstrenos.add(new Pelicula("The Matrix 4", "/images/foto.png"));
        proximosEstrenos.add(new Pelicula("West Side Story", "/images/foto.png"));

        // listas al modelo
        model.addAttribute("recomendaciones", recomendaciones);
        model.addAttribute("proximosEstrenos", proximosEstrenos);

        return "peliculas"; //
    }
}
