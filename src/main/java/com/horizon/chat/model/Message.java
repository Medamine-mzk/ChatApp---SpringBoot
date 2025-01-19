package com.horizon.chat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity // Marks this class as a JPA entity (maps to a database table)
public class Message {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @NotNull(message = "Message content cannot be null") // Ensures message content is not null
    // Ensures message content length is valid
    @Size(min = 1, max = 500, message = "Message content must be between 1 and 500 characters")
    private String content;

    private LocalDateTime timestamp; // Timestamp of when the message was sent

    @ManyToOne // Many-to-one relationship with User entity
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column for User
    private User user; // User who sent the message


    @ManyToOne // Many-to-one relationship with ChatRoom entity
    @JoinColumn(name = "chat_room_id", nullable = false) // Foreign key column for ChatRoom
    private ChatRoom chatRoom; // Chat room where the message was sent

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}