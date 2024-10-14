package com.autocine.defam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComidaController {

    @GetMapping("/comida")
    public String comida(Model model) {
        return "comida";
    }

    @PostMapping("/comida")
    public String procesarComida(Model model) {
        // Lógica de pedido de comida
        return "comida";
    }
}
