package com.doctorvee.mailgun.service.impl;

import com.doctorvee.mailgun.model.MailRequest;
import com.doctorvee.mailgun.service.MailgunService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailgunServiceImpl implements MailgunService {

    @Value("${mailgun-api-key}")
    private String apiKey;

    @Value("${mailgun-domain-name}")
    private String domainName;

    @Override
    public String sendMail(MailRequest request) {
        try {
            HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + domainName + "/messages")
                    .basicAuth("api", apiKey)
                    .queryString("from", "Doctor Vee from TestingMailGun App<doctorvee@testingmail.com>")
                    .queryString("to", request.getEmail())
                    .queryString("subject", request.getSubject())
                    .queryString("text", request.getMessage())
                    .asJson();
            log.info(String.valueOf(response.getBody()));
            String responseString = "";
            if (response.getBody().getObject().has("id")) {
                responseString = "Email Successfully Sent 👍";
            } else {
                responseString = "An error occurred 👎";
            }
            return responseString;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
