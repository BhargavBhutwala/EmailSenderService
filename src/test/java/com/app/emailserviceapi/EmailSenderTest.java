package com.app.emailserviceapi;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.*;

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
            emailService.sendEmail("bhargavbhutwala@gmail.com", "Email from Spring Boot", "This email is sent using Spring Boot while creating emailService");
        });
    }

    @Test
    public void sendEmailWithHTMLTest() {

        String html = "<html><body><h1>This is a HTML Email</h1></body></html>";

        System.out.println("sending email...");
        emailService.sendEmailWithHTML("bhargavbhutwala@gmail.com", "Email from Spring Boot", html);
    }

    @Test
    public void sendEmailWithAttachmentTest() {

        emailService.sendEmailWithAttachment("bhargavbhutwala@gmail.com", "Email from Spring Boot", "This email contains file and is sent using Spring Boot while creating emailService", new File("/Users/bharggavbhootwalaa/Coding/Projects/EmailSender/EmailSenderService/emailserviceapi/src/main/resources/static/Bhargav Bhutwala-Software Developer- Resume-NS.pdf"));
    }

    @Test
    public void sendEmailWithAttachmentStreamTest() {

        File file = new File("/Users/bharggavbhootwalaa/Coding/Projects/EmailSender/EmailSenderService/emailserviceapi/src/main/resources/static/files/Bhargav Bhutwala-Software Developer- Resume-NS.pdf");

        try {
            InputStream stream = new FileInputStream(file);

            emailService.sendEmailWithAttachment("bhargavbhutwala@gmail.com", "Email from Spring Boot", "This email contains file and is sent using Spring Boot while creating emailService", stream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
