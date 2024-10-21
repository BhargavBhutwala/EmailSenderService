package com.app.emailserviceapi.services.Impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.emailserviceapi.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

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
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(recepient);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("bhargav1999.bb@gmail.com");

        mailSender.send(mailMessage);
        logger.info("Email has been sent...");
    }

    @Override
    public void sendEmailWithAttachment(String recepient, String subject, String message, File file) {
        
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(recepient);
            helper.setSubject(subject);
            helper.setText(message, true);
            helper.setFrom("bhargav1999.bb@gmail.com");

            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(), file);

            mailSender.send(mimeMessage);
            logger.info("Email has been sent...");
            
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void sendEmailWithHTML(String recepient, String subject, String htmlContent) {
        
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,"UTF-8");
            helper.setTo(recepient);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            helper.setFrom("bhargav1999.bb@gmail.com");

            mailSender.send(mimeMessage);
            logger.info("Email has been sent...");

        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void sendEmailWithAttachment(String recepient, String subject, String message, InputStream inputStream) {
        
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(recepient);
            helper.setSubject(subject);
            helper.setText(message, true);
            helper.setFrom("bhargav1999.bb@gmail.com");

            File file = new File("/Users/bharggavbhootwalaa/Coding/Projects/EmailSender/EmailSenderService/emailserviceapi/src/main/resources/email/test.pdf");
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(), file);

            mailSender.send(mimeMessage);
            logger.info("Email has been sent...");
            
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
