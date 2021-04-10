package com.doctorvee.mailgun.model;

import lombok.Data;

@Data
public class MailRequest {
    String subject;
    String message;
    String email;
}
