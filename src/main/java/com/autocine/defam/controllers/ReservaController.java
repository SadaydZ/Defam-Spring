package com.autocine.defam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @GetMapping("/reserva")
    public String reserva(Model model) {
        return "reserva";
    }

    @PostMapping("/reserva")
    public String procesarReserva(Model model) {
        // Lógica de reserva
        return "reserva";
    }
}
