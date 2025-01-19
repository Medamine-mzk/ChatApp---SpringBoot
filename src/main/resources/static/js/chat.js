// Connect to the WebSocket server
const socket = new SockJS('/chat'); // Connect to the "/chat" endpoint
const stompClient = Stomp.over(socket); // Create a STOMP client over the WebSocket connection

// Function to handle WebSocket connection
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    // Subscribe to the "/topic/messages" destination
    stompClient.subscribe('/topic/messages', function (message) {
        const messages = document.getElementById('messages');
        const newMessage = document.createElement('div');
        newMessage.className = 'message';
        newMessage.textContent = JSON.parse(message.body).content; // Display the message content
        messages.appendChild(newMessage);
        messages.scrollTop = messages.scrollHeight; // Auto-scroll to the latest message
    });
});

// Function to send a message
function sendMessage() {
    const messageInput = document.getElementById('messageInput');
    const message = messageInput.value;

    if (message.trim() !== '') {
        // Send the message to the "/app/chat" destination
        stompClient.send("/app/chat", {}, JSON.stringify({'content': message}));
        messageInput.value = ''; // Clear the input field
    }
}

// Handle login form submission
document.getElementById('loginForm')?.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent form submission
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Perform login logic (e.g., send credentials to the server)
    fetch('/api/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    })
        .then(response => {
            if (response.ok) {
                return response.json(); // Parse the response as JSON
            } else {
                throw new Error('Login failed');
            }
        })
        .then(data => {
            // Redirect to the chat page after successful login
            window.location.href = '/chat.html';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Invalid username or password');
        });
});

/// Handle registration form submission
document.getElementById('registerForm')?.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const email = document.getElementById('email').value;

    // Perform registration logic (e.g., send data to the server)
    fetch('/api/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password, email }),
    })
        .then(response => {
            if (!response.ok) {
                // Log the response status and message
                console.error('Registration failed with status:', response.status);
                return response.json().then(err => {
                    console.error('Error details:', err);
                    throw new Error(err.message || 'Registration failed');
                });
            }
            return response.json();
        })
        .then(data => {
            alert('Registration successful! Please login.');
            window.location.href = '/index.html'; // Redirect to the login page
        })
        .catch(error => {
            console.error('Error:', error);
            alert(error.message || 'Registration failed. Please try again.');
        });
});

// Handle register link click
document.getElementById('registerLink')?.addEventListener('click', function (event) {
    event.preventDefault(); // Prevent default link behavior
    window.location.href = '/register.html'; // Redirect to the registration page
});