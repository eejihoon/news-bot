package com.newscrawler.newsletter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NewspaperArticleLetterController {
    private final EmailService emailService;

    @PostMapping("/subscribe")
    public void subscribeNewsLetter(Email email) {
        emailService.saveEmail(email);
    }
}
