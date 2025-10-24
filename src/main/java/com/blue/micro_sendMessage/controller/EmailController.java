package com.blue.micro_sendMessage.controller;

import com.blue.micro_sendMessage.model.ApiResponse;
import com.blue.micro_sendMessage.model.EmailRequest;
import com.blue.micro_sendMessage.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping
    public ApiResponse<EmailRequest> sendEmail(@Valid @RequestBody EmailRequest emailRequest) {
            return emailService.sendEmail(emailRequest);
    }
}
