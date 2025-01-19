package com.horizon.chat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/register.html", "/css/**", "/js/**").permitAll() // Allow access to static resources
                        .requestMatchers("/api/users/register","/h2-console/**").permitAll() // Allow registration without authentication
                        .requestMatchers("/chat/**").permitAll() // Allow WebSocket connections without authentication
                        .requestMatchers("/api/**").authenticated() // Secure all other API endpoints
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .httpBasic(withDefaults()) // Use HTTP Basic Authentication with default settings
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection for simplicity (not recommended for production)
                .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable()) // Disable X-Frame-Options to allow frames (required for H2 console)
        );
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user details (replace with database-based authentication later)
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}