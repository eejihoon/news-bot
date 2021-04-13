package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScienceTimesCrawlTest extends CrawlTestAbstractClass {
    @Test
    void testSciencetimesCrawlTest() {
        articles = article.getArticles(new ScienceTimesCrawl());
        assertEquals(articles.size(), 10);
    }
}
