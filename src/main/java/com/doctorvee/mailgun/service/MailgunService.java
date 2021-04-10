package com.doctorvee.mailgun.service;

import com.doctorvee.mailgun.model.MailRequest;

public interface MailgunService {
    public String sendMail(MailRequest request);
}
