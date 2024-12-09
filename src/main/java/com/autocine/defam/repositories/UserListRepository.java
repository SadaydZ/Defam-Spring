package com.autocine.defam.repositories;

import com.autocine.defam.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserListRepository extends CrudRepository<User, Long> {

    List<User> findAll(); // Devuelve todos los usuarios como una lista
}
