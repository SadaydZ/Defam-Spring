package com.autocine.defam.controllers;

import com.autocine.defam.model.Reserva;
import com.autocine.defam.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reserva")
    public String reserva(Model model) {
        return "reserva";
    }

    @PostMapping("/reserva")
    @ResponseBody // Para devolver una respuesta en formato JSON
    public String procesarReserva(@RequestBody Reserva reserva) {
        // Guardar la reserva
        reservaService.guardarReserva(reserva);
        return "Reserva guardada con éxito";
    }
}
