package com.newscrawler.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DongaCrawl implements Crawler {
    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private final static String URL = "https://www.donga.com/";
    private final static String ARTICLES_POPULARITY = "div.trend_info div.list_box.on li";
    private final static String A_SPAN_TXT = "a span.txt";
    private final static String TAG_A = "a";
    private final static String HREF = "href";

    @Override
    public List<Article> findByArticlePopularity() {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(URL).userAgent(USER_AGENT);
            Document htmlDocument = htmlDocument = connection.get();
            Elements elements = htmlDocument.select(ARTICLES_POPULARITY);

            for (Element element : elements) {
                String title = element.select(A_SPAN_TXT).text();
                String link = element.select(TAG_A).attr(HREF);
                articles.add(new Article(title, link, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
