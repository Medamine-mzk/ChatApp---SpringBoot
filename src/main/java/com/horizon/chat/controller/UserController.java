package com.horizon.chat.controller;

import com.horizon.chat.model.User;
import com.horizon.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // Marks this class as a REST controller (handles HTTP requests)
@RequestMapping("/api/users") // Base URL for all endpoints in this controller
public class UserController {

    @Autowired // Inject the UserService
    private UserService userService;

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user); // Call the service to register the user
        return ResponseEntity.ok(registeredUser); // Return the registered user with a 200 OK response
    }

    // Endpoint to fetch all usernames
    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getAllUsernames() {
        List<String> usernames = userService.getAllUsernames(); // Call the service to get all usernames
        return ResponseEntity.ok(usernames); // Return the list of usernames with a 200 OK response
    }

    // Endpoint to find a user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username) // Call the service to find the user
                .orElseThrow(() -> new RuntimeException("User not found")); // Throw an exception if the user is not found
        return ResponseEntity.ok(user); // Return the user with a 200 OK response
    }

    // Endpoint to handle user login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        boolean success = userService.validateUser(user.getUsername(), user.getPassword()); // Validate credentials
        if (success) {
            // Return a JSON response instead of plain text
            return ResponseEntity.ok().body(Map.of("message", "Login successful"));
        } else {
            // Return a JSON response for error cases as well
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid username or password"));
        }
    }
}