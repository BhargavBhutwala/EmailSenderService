package com.app.emailserviceapi.services;

import java.io.File;

public interface EmailService {

    //send email to single recipient
    void sendEmail(String recepient, String subject, String message);

    //send email to multiple recipients
    void sendEmail(String[] recepient, String subject, String message);

    //send email with attachment
    void sendEmailWithAttachment(String recepient, String subject, String message, File file);

    //send email with HTML content
    void sendEmailWithHTML(String recepient, String subject, String htmlContent);
}
