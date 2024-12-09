package com.autocine.defam.services;

import com.autocine.defam.model.User;
import com.autocine.defam.repositories.UserListRepository;
import com.autocine.defam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserListRepository userListRepository;

    // Buscar usuario por email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Registrar un usuario
    public void register(User user) {
        userRepository.save(user);
    }

    // Autenticar usuario
    public User authenticate(String email, String password) {
        Optional<User> user = findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    // Listar todos
    public List<User> findAllUsers() {
        return userListRepository.findAll();
    }

    // Borrar por ID
    public void deleteUserById(Long id) {
        userListRepository.deleteById(id);
    }

    // Borrar todos
    public void deleteAllUsers() {
        userListRepository.deleteAll();
    }

    // Listar con paginación
    public Page<User> findAllUsersWithPagination(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }
}
