package com.horizon.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // Marks this class as a configuration class
@EnableWebSocketMessageBroker // Enables WebSocket message handling, backed by a message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Enable a simple in-memory message broker to carry messages back to the client
        // Messages sent to destinations prefixed with "/topic" will be routed to the message broker
        config.enableSimpleBroker("/topic");

        // Set the prefix for messages bound for methods annotated with @MessageMapping
        // Messages sent to destinations prefixed with "/app" will be routed to @MessageMapping methods
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register the "/chat" endpoint for WebSocket connections
        // Clients will use this endpoint to connect to the WebSocket server
        registry.addEndpoint("/chat")
                .withSockJS(); // Enable SockJS fallback options for browsers that don't support WebSocket
    }
}