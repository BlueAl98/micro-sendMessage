package com.blue.micro_sendMessage.service;

import com.blue.micro_sendMessage.model.ApiResponse;
import com.blue.micro_sendMessage.model.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public ApiResponse<EmailRequest> sendEmail(EmailRequest request) {
          try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getTo());
            message.setSubject(request.getSubject());
            message.setText(request.getBody());

            mailSender.send(message);
            return new ApiResponse<>(200, "Email sent to: " + request.getTo(), request);
        } catch (Exception e) {
            //return new ApiResponse<>(400, "Failed to send email: " + e.getMessage(), null);
        return new ApiResponse<>(400, "Failed to send email: " + e.getMessage(), request);
          }
    }

}
