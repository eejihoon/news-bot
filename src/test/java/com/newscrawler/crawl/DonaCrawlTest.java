package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DonaCrawlTest extends CrawlTestAbstractClass {
    @Test
    void testDonaCrawl() {
        articles = article.getArticles(new DongaCrawl());
        assertEquals(articles.size(), 10);
    }
}
