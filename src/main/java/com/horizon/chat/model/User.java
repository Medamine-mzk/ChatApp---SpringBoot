package com.horizon.chat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity // Marks this class as a JPA entity (maps to a database table)
@Table(name = "`user`") // Escape the table name using backticks
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @NotNull(message = "Username cannot be null") // Ensures username is not null
    // Ensures username length is valid
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @Column(unique = true) // Ensures username is unique in the database
    private String username;

    @NotNull(message = "Password cannot be null") // Ensures password is not null
    // Ensures password length is valid
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Email cannot be null") // Ensures email is not null
    @Email(message = "Email should be valid") // Ensures email format is valid
    @Column(unique = true) // Ensures email is unique in the database
    private String email;

    // One-to-many relationship with Message entity
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages; // List of messages sent by the user








    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}