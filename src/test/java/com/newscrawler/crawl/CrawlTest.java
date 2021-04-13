package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrawlTest extends CrawlTestAbstractClass {
    @Test
    void testDonaCrawl() {
        articles = article.getArticles(new DongaCrawl());
        assertEquals(articles.size(), 10);
    }

    @Test
    void testHaniCrawl() {
        articles = article.getArticles(new HaniCrawl());
        assertTrue(articles.size() >= 10);
    }

    @Test
    void testJoonangCrawl() {
        articles = article.getArticles(new JoongangCrawl());
        assertEquals(articles.size(), 10);
    }

    @Test
    void testKhanCrawl() {
        articles = article.getArticles(new KhanCrawl());
        assertTrue(articles.size() >= 10);
    }

    @Test
    void testScienceTimesCrawlTest() {
        articles = article.getArticles(new ScienceTimesCrawl());
        assertEquals(articles.size(), 10);
    }
}
