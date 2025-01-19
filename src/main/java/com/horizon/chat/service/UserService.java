package com.horizon.chat.service;

import com.horizon.chat.exception.EmailAlreadyExistsException;
import com.horizon.chat.exception.UsernameAlreadyExistsException;
import com.horizon.chat.model.User;
import com.horizon.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Inject the UserRepository

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject the PasswordEncoder

    // Method to register a new user
    public User registerUser(User user) {
        // Check if the username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        // Check if the email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user to the database
        return userRepository.save(user);
    }

    // Method to find a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Method to find a user by email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to fetch all usernames
    public List<String> getAllUsernames() {
        return userRepository.findAll().stream()
                .map(User::getUsername) // Extract usernames from User objects
                .collect(Collectors.toList()); // Collect usernames into a list
    }

    // Method to validate user credentials for login
    public boolean validateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            // Use PasswordEncoder to compare the raw password with the hashed password
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false; // User not found
    }
}