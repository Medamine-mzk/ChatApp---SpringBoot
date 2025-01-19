package com.horizon.chat.repository;

import com.horizon.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// MessageRepository interface extends JpaRepository to inherit CRUD operations
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Custom query method to find all messages in a specific chat room
    // Returns a list of messages ordered by timestamp in ascending order
    List<Message> findByChatRoomIdOrderByTimestampAsc(Long chatRoomId);

    // Custom query method to find all messages sent by a specific user
    // Returns a list of messages ordered by timestamp in ascending order
    List<Message> findByUserIdOrderByTimestampAsc(Long userId);
}
