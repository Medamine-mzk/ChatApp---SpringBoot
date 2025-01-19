package com.horizon.chat.repository;

import com.horizon.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// UserRepository interface extends JpaRepository to inherit CRUD operations
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a user by username
    // Optional is used to handle the case where no user is found
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
