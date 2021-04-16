package com.newscrawler.newsletter;

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

        log.info("email : {}", emailAddress.getEmail());
        emailService.saveEmail(emailAddress);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
