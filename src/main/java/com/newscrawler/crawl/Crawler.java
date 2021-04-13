package com.newscrawler.crawl;

import java.util.List;

public interface Crawler {
    List<Article> findByArticlePopularity();
}
