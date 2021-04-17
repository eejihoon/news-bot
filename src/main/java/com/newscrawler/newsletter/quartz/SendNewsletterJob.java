package com.newscrawler.newsletter.quartz;

import com.newscrawler.newsletter.service.NewsLetterService;
import com.newscrawler.newsletter.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SendNewsletterJob {
    private final EmailService emailService;
    private final NewsLetterService newsLetterService;

    @Scheduled(cron = "0 0 6 * * *")
    public void sendNewsletter() {
        log.info("==========================메일 발송을 시작합니다.===============================");
        emailService.getEmails()
                .forEach(emailAddress -> {
                    newsLetterService.createNewsArticles(emailAddress.getEmail());
                    log.info(emailAddress +"주소로 이메일을 발송했습니다.");
                });
        log.info("========================모든 구독자에게 메일 발송을 완료했습니다.===================");
    }
}
