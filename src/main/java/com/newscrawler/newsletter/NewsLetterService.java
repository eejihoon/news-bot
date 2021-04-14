package com.newscrawler.newsletter;

import com.newscrawler.crawl.Article;
import com.newscrawler.crawl.HaniCrawl;
import com.newscrawler.mail.EmailMessage;
import com.newscrawler.mail.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class NewsLetterService {
    private final MailSender mailSender;
    private final TemplateEngine templateEngine;

    public void createNewsArticles(String email) {
        Context context = getContext();
        String message = templateEngine.process("mail/news", context);
        String subject = LocalDateTime.now() +" 뉴스 레터입니다.";
        EmailMessage emailMessage = new EmailMessage(email, subject, message);
        mailSender.sendMail(emailMessage);
    }

    private Context getContext() {
        Article article = new Article();
        List<Article> articles = article.getArticles(new HaniCrawl());
        Context context = new Context();
        context.setVariable("articles", articles);
        context.setVariable("host", "localhost:8081");
        return context;
    }
}
