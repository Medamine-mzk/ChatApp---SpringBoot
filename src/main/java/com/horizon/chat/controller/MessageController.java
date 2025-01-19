package com.horizon.chat.controller;

import com.horizon.chat.model.Message;
import com.horizon.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller (handles HTTP requests)
@RequestMapping("/api/messages") // Base URL for all endpoints in this controller
public class MessageController {

    @Autowired // Inject the MessageService
    private MessageService messageService;

    // Endpoint to send a message
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message sentMessage = messageService.sendMessage(message); // Call the service to send the message
        return ResponseEntity.ok(sentMessage); // Return the sent message with a 200 OK response
    }

    // Endpoint to fetch all messages in a chat room
    @GetMapping("/chatroom/{chatRoomId}")
    public ResponseEntity<List<Message>> getMessagesByChatRoom(@PathVariable Long chatRoomId) {
        List<Message> messages = messageService.getMessagesByChatRoom(chatRoomId); // Call the service to get messages
        return ResponseEntity.ok(messages); // Return the list of messages with a 200 OK response
    }
}