package com.newscrawler.newsletter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubscribeNewsletterController {
    @GetMapping("/subscribe")
    public void subscribe() {
    }
}
