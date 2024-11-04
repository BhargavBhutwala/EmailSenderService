package com.app.emailserviceapi.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.emailserviceapi.entities.CustomResponse;
import com.app.emailserviceapi.entities.EmailRequest;
import com.app.emailserviceapi.services.EmailService;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){

        emailService.sendEmailWithHTML(emailRequest.getRecipient(), emailRequest.getSubject(), emailRequest.getMessage());
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully").status(HttpStatus.OK).success(true).build());

    }

    @PostMapping("/send-with-file")
    public ResponseEntity<?> sendEmailWithAttachment(@RequestPart EmailRequest emailRequest, @RequestPart MultipartFile attachment){

        try {
            emailService.sendEmailWithAttachment(emailRequest.getRecipient(), emailRequest.getSubject(), emailRequest.getMessage(), attachment.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully").status(HttpStatus.OK).success(true).build());
    }
}
