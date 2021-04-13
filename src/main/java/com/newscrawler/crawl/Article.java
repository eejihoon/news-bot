package com.newscrawler.crawl;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {
    private String title;
    private String photoUrl;
    private String link;

    public Article(){};

    public Article(String title, String link, String photoUrl) {
        this.title = title;
        this.link = link;
        this.photoUrl = photoUrl;
    }

    public List<Article> getArticles(Crawler crawler) {
        return crawler.findByArticlePopularity();
    }
}
