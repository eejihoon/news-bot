package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoongangCrawlTest {
    @Test
    void testSearchArticle() {
        JoongangCrawl joongangCrawl = new JoongangCrawl();
        List<Article> articles = joongangCrawl.findByArticlePopularity();

        assertEquals(articles.size(), 10);
    }
}
