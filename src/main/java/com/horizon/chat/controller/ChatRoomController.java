package com.horizon.chat.controller;

import com.horizon.chat.model.ChatRoom;
import com.horizon.chat.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Marks this class as a REST controller (handles HTTP requests)
@RequestMapping("/api/chatrooms") // Base URL for all endpoints in this controller
public class ChatRoomController {

    @Autowired // Inject the ChatRoomService
    private ChatRoomService chatRoomService;

    // Endpoint to create a new chat room
    @PostMapping("/create")
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody ChatRoom chatRoom) {
        ChatRoom createdChatRoom = chatRoomService.createChatRoom(chatRoom); // Call the service to create the chat room
        return ResponseEntity.ok(createdChatRoom); // Return the created chat room with a 200 OK response
    }

    // Endpoint to find a chat room by name
    @GetMapping("/{name}")
    public ResponseEntity<ChatRoom> findByName(@PathVariable String name) {
        ChatRoom chatRoom = chatRoomService.findByName(name) // Call the service to find the chat room
                .orElseThrow(() -> new RuntimeException("Chat room not found")); // Throw an exception if the chat room is not found
        return ResponseEntity.ok(chatRoom); // Return the chat room with a 200 OK response
    }
}