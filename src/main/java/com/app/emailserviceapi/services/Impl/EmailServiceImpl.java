package com.app.emailserviceapi.services.Impl;

import java.io.File;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.emailserviceapi.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

    // @Autowired
    // private MailSender mailSender;

    @Autowired
    private JavaMailSender mailSender;

    private Logger logger = Logger.getLogger("EmailServiceImpl.class");

    @Override
    public void sendEmail(String recepient, String subject, String message) {

        SimpleMailMessage messageToSend = new SimpleMailMessage();

        messageToSend.setTo(recepient);
        messageToSend.setSubject(subject);
        messageToSend.setText(message);
        messageToSend.setFrom("bhargav1999.bb@gmail.com");
        
        mailSender.send(messageToSend);
        logger.info("Email has been sent...");
    }

    @Override
    public void sendEmail(String[] recepient, String subject, String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmail'");
    }

    @Override
    public void sendEmailWithAttachment(String recepient, String subject, String message, File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmailWithAttachment'");
    }

    @Override
    public void sendEmailWithHTML(String recepient, String subject, String htmlContent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmailWithHTML'");
    }

}
