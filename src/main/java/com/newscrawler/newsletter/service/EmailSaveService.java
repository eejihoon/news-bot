package com.newscrawler.newsletter.service;

import com.newscrawler.newsletter.domain.EmailAddress;
import com.newscrawler.newsletter.exception.EmailAddressDuplicateException;
import com.newscrawler.newsletter.repository.EmailAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailSaveService {
    private final EmailAddressRepository emailAddressRepository;

    public void saveEmail(EmailAddress emailAddress) throws EmailAddressDuplicateException {
        if (isAlreadyExistsEmail(emailAddress))
            throw new EmailAddressDuplicateException(emailAddress.getEmail()+"은 이미 존재하는 이메일입니다.");
        emailAddressRepository.save(emailAddress);
    }

    public List<EmailAddress> getEmails() {
        return emailAddressRepository.findAll();
    }

    private boolean isAlreadyExistsEmail(EmailAddress emailAddress) {
        return emailAddressRepository.existsByEmail(emailAddress.getEmail());
    }
}
