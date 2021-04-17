package com.newscrawler.newsletter.service;

import com.newscrawler.newsletter.domain.EmailAddress;
import com.newscrawler.newsletter.exception.EmailAddressDuplicateException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    private List<EmailAddress> emailAddresses = new ArrayList<>();

    public void saveEmail(EmailAddress emailAddress) throws EmailAddressDuplicateException {
        if (isAlreadyExistsEmail(emailAddress))
            throw new EmailAddressDuplicateException(emailAddress.getEmail()+"은 이미 존재하는 이메일입니다.");
        emailAddresses.add(emailAddress);
    }

    public List<EmailAddress> getEmails() {
        return emailAddresses;
    }

    private boolean isAlreadyExistsEmail(EmailAddress emailAddress) {
        return emailAddresses.contains(emailAddress);
    }
}
