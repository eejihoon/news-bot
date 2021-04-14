package com.newscrawler.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HaniCrawl implements Crawler {
    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private final static String URL = "http://www.hani.co.kr";
    private final static String HTTP = "http:";
    private final static String TAG_A = "span.article-photo a";
    private final static String HREF = "href";
    private final static String TAG_IMG = "span.article-photo img";
    private final static String SRC = "src";
    private final static String TAG_H4 = "h4.article-title";
    private final static String ARTICLES_POPULARITY = "div.list div.article-right";

    @Override
    public List<Article> findByArticlePopularity(Article article) {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(URL).userAgent(USER_AGENT);
            Document htmlDocument = htmlDocument = connection.get();
            Elements elements = htmlDocument.select(ARTICLES_POPULARITY);

            for (Element element : elements) {
                String title = element.select(TAG_H4).text();
                String photoUrl = HTTP + element.select(TAG_IMG).attr(SRC);
                String link = HTTP + element.select(TAG_A).attr(HREF);
                articles.add(new Article(title, link, photoUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
