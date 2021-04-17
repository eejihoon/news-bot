package com.newscrawler.newsletter.service;

import com.newscrawler.newsletter.domain.EmailAddress;
import com.newscrawler.newsletter.repository.EmailAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmailDeleteService {
    private final EmailAddressRepository emailAddressRepository;
    public void deleteEmail(EmailAddress emailAddress) {
        EmailAddress findEmail = emailAddressRepository.findByEmail(emailAddress.getEmail());
        emailAddressRepository.delete(findEmail);
    }
}
