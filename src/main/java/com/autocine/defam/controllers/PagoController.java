package com.autocine.defam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagoController {

    @GetMapping("/pago")
    public String pago(Model model) {
        return "pago";
    }

    @PostMapping("/pago")
    public String procesarPago(Model model) {
        // Lógica de pago
        return "pago";
    }
}
