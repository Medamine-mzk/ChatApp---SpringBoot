package com.horizon.chat.controller;

import com.horizon.chat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller // Marks this class as a WebSocket controller
public class WebSocketController {

    // Handles messages sent to the "/app/chat" destination
    @MessageMapping("/chat") // Maps messages sent to "/app/chat" to this method
    @SendTo("/topic/messages") // Sends the return value to "/topic/messages"
    public Message sendMessage(Message message) {
        // Process the incoming message (e.g., save it to the database)
        // For now, just return the message to broadcast it to all subscribers
        return message;
    }
}