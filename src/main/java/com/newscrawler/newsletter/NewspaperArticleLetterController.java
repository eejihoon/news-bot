package com.newscrawler.newsletter;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewspaperArticleLetterController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/subscribe")
    public void subscribeNewsLetter() {

    }

}
