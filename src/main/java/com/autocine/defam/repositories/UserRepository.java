package com.autocine.defam.repositories;

import com.autocine.defam.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // Usuarios hardcodeados
        users.add(new User("Usuario1", "user1@gmail.com", "password1"));
        users.add(new User("Usuario2", "user2@gmail.com", "password2"));
        users.add(new User("Anderson", "anderson@gmail.com", "123456"));
    }

    public User findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public void save(User user) {
        users.add(user);
    }
}
