package com.newscrawler.newsletter.web;

import com.newscrawler.newsletter.domain.EmailAddress;
import com.newscrawler.newsletter.exception.EmailAddressDuplicateException;
import com.newscrawler.newsletter.service.EmailDeleteService;
import com.newscrawler.newsletter.service.EmailSaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SubscribeNewsletterApiController {
    public static final String URL_API_SUBSCRIBE = "/api/subscribe";
    private final EmailSaveService emailSaveService;
    private final EmailDeleteService emailDeleteService;

    @PostMapping(URL_API_SUBSCRIBE)
    public ResponseEntity<String> subscribeNewsLetter(@RequestBody @Valid EmailAddress emailAddress, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Error: {}", errors.getFieldError());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            log.info("email : {}", emailAddress.getEmail());
            emailSaveService.saveEmail(emailAddress);
        } catch (EmailAddressDuplicateException e) {
            log.error("error: {} ", e);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(URL_API_SUBSCRIBE)
    public void cancelSubscribe(@RequestBody @Valid EmailAddress emailAddress, Errors errors) {
        if (errors.hasErrors())
            log.error("error: {} ", errors.getFieldError());

        emailDeleteService.deleteEmail(emailAddress);
    }
}
