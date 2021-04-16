package com.newscrawler.newsletter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    private List<EmailAddress> emailAddresses = new ArrayList<>();

    public void saveEmail(EmailAddress emailAddress) {
        emailAddresses.add(emailAddress);
    }

    public List<EmailAddress> getEmails() {
        return emailAddresses;
    }
}
