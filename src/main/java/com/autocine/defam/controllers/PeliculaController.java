package com.autocine.defam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocine.defam.model.Pelicula;
import com.autocine.defam.services.PeliculaServicesImpl;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private final PeliculaServicesImpl peliculaServices;

    public PeliculaController(PeliculaServicesImpl peliculaServices) {
        this.peliculaServices = peliculaServices;
    }

    // Obtener todas las películas y mostrarlas en la vista de Thymeleaf
    @GetMapping("/listar")
    public String obtenerTodasLasPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaServices.obtenerTodasLasPeliculas();

        model.addAttribute("peliculas", peliculas);
        return "peliculas"; // Vista que has creado
    }

    // Obtener una película por su título y mostrarla
    @GetMapping("/{titulo}")
    public String obtenerPeliculaPorTitulo(@PathVariable String titulo, Model model) {
        Pelicula pelicula = peliculaServices.obtenerPeliculaPorTitulo(titulo);
        if (pelicula != null) {
            model.addAttribute("pelicula", pelicula);
            return "detalle_pelicula"; // Devuelve la vista 'detalle_pelicula.html' con la película
        } else {
            return "error"; // Si no se encuentra la película, muestra una página de error
        }
    }

    // Agregar una nueva película
    @GetMapping("/nuevo")
    public String mostrarFormularioPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula(null, null, 0, null, 0, null, null, null)); // Muestra un formulario
                                                                                                // vacío para agregar
                                                                                                // una nueva película
        return "formulario_pelicula"; // Devuelve la vista del formulario 'formulario_pelicula.html'
    }

    @PostMapping("/nuevo")
    public String agregarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaServices.agregarPelicula(pelicula);
        return "redirect:/peliculas"; // Después de agregar, redirige a la lista de películas
    }

    // Eliminar una película por su título
    @GetMapping("/eliminar/{titulo}")
    public String eliminarPelicula(@PathVariable String titulo) {
        peliculaServices.eliminarPelicula(titulo);
        return "redirect:/peliculas"; // Después de eliminar, redirige a la lista de películas
    }

}
