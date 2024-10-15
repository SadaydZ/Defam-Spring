package com.autocine.defam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocine.defam.model.Pelicula;
import com.autocine.defam.services.IPeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping("/listar")
    public String listarPeliculas(Model model) {
        List<Pelicula> listaPeliculas = peliculaService.obtenerTodasLasPeliculas();
        List<Pelicula> listaEstrenos = peliculaService.obtenerEstrenos();
        model.addAttribute("peliculas", listaPeliculas);
        model.addAttribute("estrenos", listaEstrenos);
        return "peliculas"; // nombre de la vista (listarPeliculas.html)
    }

    @PostMapping("/agregar")
    public String agregarPelicula(Pelicula pelicula) {
        peliculaService.agregarPelicula(pelicula);
        return "redirect:/peliculas/listar";
    }
}
