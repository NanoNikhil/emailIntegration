package com.email.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.dto.EmailRequest;
import com.email.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class NotificationController {

	
	@Autowired
    private EmailService service;

    @PostMapping("/sendEmail")
    public String sendTextEmail(@RequestBody EmailRequest request) {
        return service.sendSimpleEmail(request);
    }
    
    @GetMapping("/sendEmails")
    public String sendEmail() {
         service.sendEmail("nikhil.n2k22@gmail.com","Test Body","Test Subject");
         return "Sent Successfully";
    }
    
    @PostMapping("/sendAttachment")
    public String sendEmailWithAttachment(@RequestBody EmailRequest request) throws MessagingException {
        return service.sendEmailWithAttachment(request);
    }
    
}
