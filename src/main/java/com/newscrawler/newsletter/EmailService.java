package com.newscrawler.newsletter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    private List<Email> emails = new ArrayList<>();

    public void saveEmail(Email email) {
        emails.add(email);
    }

    public List<Email> getEmails() {
        return emails;
    }
}
