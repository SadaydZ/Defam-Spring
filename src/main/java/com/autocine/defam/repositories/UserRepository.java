package com.autocine.defam.repositories;

import com.autocine.defam.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    // Método para encontrar todos los usuarios con paginación
    Page<User> findAll(Pageable pageable);
}
