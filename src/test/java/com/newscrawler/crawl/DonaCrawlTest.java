package com.newscrawler.crawl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DonaCrawlTest {
    @Test
    void testDonaCrawl() {
        DongaCrawl dongaCrawl = new DongaCrawl();
        List<Article> articles = dongaCrawl.findByArticlePopularity();

        assertEquals(articles.size(), 10);
    }
}
