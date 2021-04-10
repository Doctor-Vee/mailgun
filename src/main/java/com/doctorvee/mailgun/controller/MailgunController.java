package com.doctorvee.mailgun.controller;

import com.doctorvee.mailgun.model.MailRequest;
import com.doctorvee.mailgun.service.MailgunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MailgunController")
@RequestMapping("/mailgun")
public class MailgunController {

    @Autowired
    private MailgunService mailgunService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody MailRequest request){
        String response = mailgunService.sendMail(request);
        return ResponseEntity.ok(response);
    }

}
