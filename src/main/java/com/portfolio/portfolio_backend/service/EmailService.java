package com.portfolio.portfolio_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final String adminEmail ="irshadk12421@gmail.com";
    public void sendNotificationToAdmin(String name,String email,String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(adminEmail);
        mailMessage.setSubject("New Contact Form Submission from " + name);
        mailMessage.setText("Name: " + name + "\nEmail: " + email + "\n\nMessage:\n" + message);
        mailSender.send(mailMessage);
    }
    public void sendAutoReplyToUser(String name, String userEmail) {
        SimpleMailMessage reply = new SimpleMailMessage();
        reply.setTo(userEmail);
        reply.setSubject("Thanks for contacting me!");
        reply.setText("Hi " + name + ",\n\nThank you for reaching out to me. I will get back to you soon!\n\nRegards,\nRoshan Khan");
        mailSender.send(reply);
    }
}
