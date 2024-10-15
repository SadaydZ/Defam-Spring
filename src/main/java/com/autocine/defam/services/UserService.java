package com.autocine.defam.services;

import com.autocine.defam.model.User;
import com.autocine.defam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login exitoso
        }
        return null; // Credenciales incorrectas
    }

    public void register(User user) {
        userRepository.save(user); // Registro de un nuevo usuario
    }
}
