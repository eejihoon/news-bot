package com.newscrawler.newsletter.web;

import com.newscrawler.newsletter.domain.EmailAddress;
import com.newscrawler.newsletter.exception.EmailAddressDuplicateException;
import com.newscrawler.newsletter.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SubscribeNewsletterApiController {
    private final EmailService emailService;

    @PostMapping("/api/subscribe")
    public ResponseEntity<String> subscribeNewsLetter(@RequestBody @Valid EmailAddress emailAddress, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Error: {}", errors.getFieldError());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            log.info("email : {}", emailAddress.getEmail());
            emailService.saveEmail(emailAddress);
        } catch (EmailAddressDuplicateException e) {
            log.error("error: {} ", e);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
