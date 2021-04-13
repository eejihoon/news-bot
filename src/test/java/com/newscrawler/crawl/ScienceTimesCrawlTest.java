package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScienceTimesCrawlTest {
    @Test
    void testSciencetimesCrawlTest() {
        ScienceTimesCrawl sciencetimesCrawl = new ScienceTimesCrawl();
        List<Article> articles = sciencetimesCrawl.findByArticlePopularity();

        assertEquals(articles.size(), 10);
    }
}
