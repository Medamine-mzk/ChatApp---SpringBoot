package com.horizon.chat.repository;

import com.horizon.chat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// ChatRoomRepository interface extends JpaRepository to inherit CRUD operations
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    // Custom query method to find a chat room by name
    // Optional is used to handle the case where no chat room is found
    Optional<ChatRoom> findByName(String name);

    // Custom query method to check if a chat room name already exists
    // Returns true if the chat room name exists, false otherwise
    boolean existsByName(String name);
}
