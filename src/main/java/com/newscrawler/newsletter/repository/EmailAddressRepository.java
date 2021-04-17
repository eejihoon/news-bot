package com.newscrawler.newsletter.repository;

import com.newscrawler.newsletter.domain.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {
    boolean existsByEmail(String email);
}
