package com.horizon.chat.service;

import com.horizon.chat.model.Message;
import com.horizon.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository; // Inject the MessageRepository

    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now()); // Set the current timestamp
        return messageRepository.save(message); // Save the message to the database
    }

    public List<Message> getMessagesByChatRoom(Long chatRoomId) {
        // Find all messages in a chat room
        return messageRepository.findByChatRoomIdOrderByTimestampAsc(chatRoomId);
    }
}
