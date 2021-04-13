package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoongangCrawlTest extends CrawlTestAbstractClass {
    @Test
    void testSearchArticle() {
        articles = article.getArticles(new JoongangCrawl());
        assertEquals(articles.size(), 10);
    }
}
