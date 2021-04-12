package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KhanCrawlTest {
    @Test
    void testSearchArticle() {
        KhanCrawl khan = new KhanCrawl();
        List<Article> articles = khan.findByArticlePopularity();

        assertTrue(articles.size() >= 10);
    }
}
