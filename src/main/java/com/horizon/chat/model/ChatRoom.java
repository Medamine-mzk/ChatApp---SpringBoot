package com.horizon.chat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;


@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity // Marks this class as a JPA entity (maps to a database table)
public class ChatRoom {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @NotNull(message = "Chat room name cannot be null") // Ensures chat room name is not null
    // Ensures chat room name length is valid
    @Size(min = 3, max = 50, message = "Chat room name must be between 3 and 50 characters")
    @Column(unique = true) // Ensures chat room name is unique in the database
    private String name;

    @NotNull(message = "Topic cannot be null") // Ensures topic is not null
    // Ensures topic length is valid
    @Size(min = 3, max = 100, message = "Topic must be between 3 and 100 characters")
    private String topic;

    // One-to-many relationship with Message entity
    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages; // List of messages in this chat room

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}