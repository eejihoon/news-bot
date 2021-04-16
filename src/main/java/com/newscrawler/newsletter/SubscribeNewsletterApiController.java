package com.newscrawler.newsletter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SubscribeNewsletterApiController {
    private final EmailService emailService;

    @PostMapping("/api/subscribe/{emailAddress}")
    public ResponseEntity<String> subscribeNewsLetter(@PathVariable EmailAddress emailAddress) {
        log.info("email : {}", emailAddress.getEmail());
        emailService.saveEmail(emailAddress);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
