package com.autocine.defam.controllers;

import com.autocine.defam.model.User;
import com.autocine.defam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

    @Autowired
    private UserService userService;

    // Mostrar todos los usuarios
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // Vista HTML para mostrar usuarios
    }

    // Listar usuarios con paginación
    @GetMapping("/paginated")
    public String listUsersPaginated(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      Model model) {
        Page<User> userPage = userService.findAllUsersWithPagination(page, size);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "user-list-paginated"; // Vista para mostrar usuarios con paginación
    }

    // Borrar un usuario por ID
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    // Borrar todos los usuarios
    @PostMapping("/delete-all")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "redirect:/admin/users";
    }
}
