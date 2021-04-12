package com.newscrawler.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KhanCrawl {
    private static final String URL = "http://www.khan.co.kr/";
    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private static final String ARTICLES_POPULARITY = "div.bestview_news div.newscont_wrap li.num_color";
    public static final String TAG_A = "a";
    private static final String HTTP = "http://";
    private static final String HREF = "href";


    public List<Article> findByArticlePopularity() {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(URL).userAgent(USER_AGENT);
            Document htmlDocument = htmlDocument = connection.get();
            Elements elements = htmlDocument.select(ARTICLES_POPULARITY);

            for (Element element : elements) {
                String title = element.select(TAG_A).text();
                String link = HTTP + element.select(TAG_A).attr(HREF);
                articles.add(new Article(title, link, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
