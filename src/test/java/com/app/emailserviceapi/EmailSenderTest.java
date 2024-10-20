package com.app.emailserviceapi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.emailserviceapi.services.EmailService;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmailTest(){
        System.out.println("sending email...");
        assertDoesNotThrow(() -> {
            emailService.sendEmail("bhutwalabhargav@gmail.com", "Email from Spring Boot", "This email is sent using Spring Boot while creating emailService");
        });
    }

}
