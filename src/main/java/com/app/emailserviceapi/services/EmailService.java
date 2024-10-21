package com.app.emailserviceapi.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //send email to single recipient
    void sendEmail(String recepient, String subject, String message);

    //send email to multiple recipients
    void sendEmail(String[] recepient, String subject, String message);

    //send email with attachment
    void sendEmailWithAttachment(String recepient, String subject, String message, File file);

    void sendEmailWithAttachment(String recepient, String subject, String message, InputStream inputStream);

    //send email with HTML content
    void sendEmailWithHTML(String recepient, String subject, String htmlContent);
}
