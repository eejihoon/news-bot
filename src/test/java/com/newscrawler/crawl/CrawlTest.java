package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrawlTest {
    @Test
    void testCrawl() {
        Article article = new Article();
        List<Crawler> crawlers = Arrays.asList(
                new HaniCrawl(),
                new KhanCrawl(),
                new DongaCrawl(),
                new DongaCrawl(),
                new JoongangCrawl(),
                new ScienceTimesCrawl());

        crawlers.forEach(
                crawler -> assertTrue(crawler.findByArticlePopularity(article).size() >= 5));
    }
}
