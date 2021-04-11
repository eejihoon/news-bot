package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HaniCrawlerTest {
    @Test
    void testSearchArticle() {
        Article article = new Article();
        List<Article> articles = article.getArticles();

        assertTrue(articles.size() >= 10);
    }
}
