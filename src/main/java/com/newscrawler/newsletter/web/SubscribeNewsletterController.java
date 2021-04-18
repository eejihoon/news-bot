package com.newscrawler.newsletter.web;

import com.newscrawler.crawl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SubscribeNewsletterController {
    @GetMapping("/subscribe")
    public void subscribe() {
    }
    //TODO Test Controller 추후 삭제
    @GetMapping("news")
    public String test(Model model) {
        Article article = new Article();
        List<Crawler> crawlers = Arrays.asList(
                new HaniCrawl(),
                new KhanCrawl(),
                new DongaCrawl(),
                new DongaCrawl(),
                new JoongangCrawl(),
                new ScienceTimesCrawl());

        List<Article> articles = new ArrayList<>();

        crawlers.forEach(crawler -> {
            List<Article> articles1 = article.getArticles(crawler);
            articles1.forEach(a -> articles.add(a));
        });

        model.addAttribute("articles", articles);

        return "mail/news";
    }
}
