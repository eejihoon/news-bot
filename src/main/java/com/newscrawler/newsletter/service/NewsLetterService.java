package com.newscrawler.newsletter.service;

import com.newscrawler.crawl.*;
import com.newscrawler.mail.EmailMessage;
import com.newscrawler.mail.MailSend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NewsLetterService {
    private final MailSend mailSend;
    private final TemplateEngine templateEngine;

    public void createNewsArticles(String email) {
        Context context = getContext();
        String message = templateEngine.process("mail/news", context);
        String subject = LocalDateTime.now() +" 뉴스 레터입니다.";
        EmailMessage emailMessage = new EmailMessage(email, subject, message);
        mailSend.sendMail(emailMessage);
    }

    private Context getContext() {
        List<Article> articles = getArticles();
        Context context = new Context();

        context.setVariable("articles", articles);
        context.setVariable("host", "localhost:8081");
        return context;
    }

    private List<Article> getArticles() {
        Article article = new Article();
        List<Article> articles = new ArrayList<>();
        List<Crawler> crawlers = getAllCrawl();

        crawlers.forEach(crawler -> {
            List<Article> byArticlePopularity = crawler.findByArticlePopularity(article);
            byArticlePopularity.forEach(arti -> articles.add(arti));
        });

        return articles;
    }

    private List<Crawler> getAllCrawl() {
        return Arrays.asList(
                new HaniCrawl(),
                new KhanCrawl(),
                new DongaCrawl(),
                new DongaCrawl(),
                new JoongangCrawl(),
                new ScienceTimesCrawl());
    }
}
