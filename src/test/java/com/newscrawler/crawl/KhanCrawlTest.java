package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KhanCrawlTest extends CrawlTestAbstractClass {
    @Test
    void testSearchArticle() {
        articles = article.getArticles(new KhanCrawl());
        assertTrue(articles.size() >= 10);
    }
}
