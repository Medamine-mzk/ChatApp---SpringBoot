
# Spring Boot Chat Application

This project is a real-time chat application built with **Spring Boot**. It allows users to register, log in, and participate in both general and topic-based chat rooms. The application uses **WebSockets** for real-time communication, Java **Streams** and **Collections** for efficient data handling, and follows **Clean Architecture** for a modular, testable, and maintainable codebase.

## Features

- **User Registration and Login**: Secure authentication for users to register and log in.
- **General Chat Room**: A public chat room where all users can communicate.
- **Topic-based Chat Rooms**: Join and participate in topic-specific chat rooms.
- **Real-time Messaging**: Messages are exchanged in real-time using **WebSockets**.
- **Efficient Code**: Java **Streams** and **Collections** are used for clean and efficient code.
- **Object-Oriented Programming**: The project follows **OOP** principles for maintainable and modular code.
- **In-memory Database**: User data and chat logs are stored in an **H2 in-memory database** for simplicity.

## Architecture

The application follows a **Clean Architecture** approach, ensuring:
- Separation of concerns between different layers (Controller, Service, Repository, etc.).
- Modular design for easier testing, maintenance, and future extensions.
- Code is organized into layers to keep the application scalable and maintainable.

## Technologies Used

- **Spring Boot** (Backend)
- **WebSockets** (Real-time communication)
- **Java Streams and Collections** (Efficient data processing)
- **H2 In-memory Database** (Data persistence)
- **Clean Architecture** (Modular, maintainable code)

## Prerequisites

- **Java 17+** (Ensure you have a JDK installed)
- **Maven** (For project build and dependency management)
- **IDE** (Optional: IntelliJ IDEA, Eclipse, VS Code, etc.)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/chat-application.git
   ```

2. Navigate to the project directory:

   ```bash
   cd chat-application
   ```

3. Build the project with Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Access the chat application in your browser:

   ```
   http://localhost:8080
   ```

## Usage

- **Register**: Create an account to start using the chat system.
- **Login**: Use your credentials to log into the system.
- **Join Chat Rooms**: You can join the general chat room or choose from various topic-based chat rooms.
- **Send Messages**: Once logged in, you can send and receive messages in real-time.

## Architecture Overview

The application is structured as follows:

- **Controller Layer**: Handles HTTP requests and WebSocket communication.
- **Service Layer**: Contains the business logic for user management and messaging.
- **Repository Layer**: Manages the interaction with the H2 in-memory database.
- **WebSocket Configuration**: Configures WebSocket for real-time messaging.

## Code Structure

```
src/
 ├── main/
 │    ├── java/
 │    │    ├── com/
 │    │    │    └── chat/
 │    │    │        ├── controller/
 │    │    │        ├── model/
 │    │    │        ├── repository/
 │    │    │        ├── service/
 │    │    │        ├── websocket/
 │    ├── resources/
 │    │    ├── application.properties
 └── pom.xml
```

- **controller/**: Contains REST controllers for user and chat room management.
- **model/**: Contains entity classes representing users, messages, and chat rooms.
- **repository/**: Interfaces for interacting with the database.
- **service/**: Contains service classes for business logic.
- **websocket/**: WebSocket configuration and handling of real-time communication.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- **Spring Boot**: For building the backend of the application.
- **WebSockets**: For enabling real-time communication between users.
- **H2 Database**: For providing a lightweight in-memory database for storing chat logs and user data.
