package com.autocine.defam.controllers;

import com.autocine.defam.model.User;
import com.autocine.defam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    // Página de inicio de sesión
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Formulario de inicio de sesión
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.login(email, password);
        if (user != null) {
            return "redirect:/"; // Login exitoso
        }
        model.addAttribute("error", "Invalid email or password");
        return "login"; // Vuelve a mostrar la página de login con error
    }

    // Página de registro
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    // Formulario de registro
    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User user = new User(name, email, password);
        userService.register(user);
        return "redirect:/login"; // Nos redirige al login después del registro
    }
}
