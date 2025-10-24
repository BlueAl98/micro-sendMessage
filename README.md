# Micro Send Message Service (Spring Boot)

![Microservice](https://img.shields.io/badge/Spring-Boot-green)
![Java](https://img.shields.io/badge/Java-17-blue)
![REST API](https://img.shields.io/badge/REST-API-orange)

---

## 📌 Overview

Micro Send Message is a lightweight Spring Boot microservice for sending emails. It exposes a REST API endpoint to send emails using `JavaMailSender` with robust error handling and validation.

This microservice is ideal for integration into larger applications that require email notifications, alerts, or confirmations.

---

## 🚀 Features

- Send emails via REST API
- Request validation with `@NotBlank` and `@Email`
- Global exception handling with detailed error responses
- JSON API responses using a unified `ApiResponse` model
- Easy to extend for additional message providers

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Mail
- Jakarta Validation
- Maven/Gradle (build tool)

---

## 📁 Project Structure

```
src/main/java/com/blue/micro_sendMessage/
├── MicroSendMessageApplication.java  # Entry point
├── configuration/
│   └── GlobalExceptionHandler.java  # Handles exceptions globally
├── controller/
│   └── EmailController.java  # API endpoints
├── model/
│   ├── ApiResponse.java  # Standard API response
│   └── EmailRequest.java  # Email request payload
└── service/
    └── EmailService.java  # Email sending logic
```

```
src/test/java/com/blue/micro_sendMessage/
└── MicroSendMessageApplicationTests.java  # Unit tests
```

---

## 📬 API Endpoints

### **Send Email**

**POST** `/email`

- **Headers:**
  - `Content-Type: application/json`
- **Request Body:**

```json
{
  "to": "recipient@example.com",
  "subject": "Test Email",
  "body": "Hello, this is a test message."
}
```

- **Responses:**

**Success:** 200 OK
```json
{
  "status": 200,
  "message": "Email sent to: recipient@example.com",
  "data": {
    "to": "recipient@example.com",
    "subject": "Test Email",
    "body": "Hello, this is a test message."
  }
}
```

**Validation Error:** 400 Bad Request
```json
{
  "status": 400,
  "message": "Validation failed",
  "error": "to: Recipient email is required, subject: Subject cannot be blank"
}
```

**Malformed JSON:** 400 Bad Request
```json
{
  "status": 400,
  "message": "Malformed JSON request",
  "error": "Unexpected character ('"' (code 34))"
}
```

**Server Error:** 500 Internal Server Error
```json
{
  "status": 500,
  "message": "Internal server error",
  "error": "Detailed exception message"
}
```

---

## 🔧 Setup & Configuration

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/micro-send-message.git
cd micro-send-message
```

2. **Configure mail properties in `application.properties` or `application.yml`**
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

3. **Build & Run:**
```bash
./mvnw spring-boot:run
# or
./gradlew bootRun
```

4. **Test API**
Use Postman, curl, or any REST client to POST to `/email`.

---

## 🛡️ Exception Handling

Handled by `GlobalExceptionHandler`:

- `MethodArgumentNotValidException` → validation errors
- `HttpMessageNotReadableException` → malformed JSON
- `Exception` → fallback for all other errors

All responses are wrapped in `ApiResponse`.

---

## 🧪 Testing

- Unit tests included in `MicroSendMessageApplicationTests.java`
- Run using:
```bash
./mvnw test
# or
./gradlew test
```

---

## ⚡ Contribution

Feel free to fork the project, open issues, and submit pull requests. This microservice is designed to be simple and extendable.

---

## 📄 License

MIT License. Free to use and modify.

