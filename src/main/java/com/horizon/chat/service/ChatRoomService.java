package com.horizon.chat.service;

import com.horizon.chat.model.ChatRoom;
import com.horizon.chat.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository; // Inject the ChatRoomRepository

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        // Check if the chat room name already exists
        if (chatRoomRepository.existsByName(chatRoom.getName())) {
            throw new RuntimeException("Chat room name already exists");
        }
        return chatRoomRepository.save(chatRoom); // Save the chat room to the database
    }

    public Optional<ChatRoom> findByName(String name) {
        return chatRoomRepository.findByName(name); // Find a chat room by name
    }
}
