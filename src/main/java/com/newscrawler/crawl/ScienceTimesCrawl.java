package com.newscrawler.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScienceTimesCrawl implements Crawler {
    private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private final static String URL = "https://www.sciencetimes.co.kr/";
    private final static String ARTICLES_POPULARITY = "div.weekly_news ul.board_list.type_view_cont li";
    private final static String STRONG_TXT = "strong.tit";
    private final static String TAG_A = "a";
    private final static String HREF = "href";

    @Override
    public List<Article> findByArticlePopularity(Article article) {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(URL).userAgent(USER_AGENT);
            Document htmlDocument = htmlDocument = connection.get();
            Elements elements = htmlDocument.select(ARTICLES_POPULARITY);

            for (Element element : elements) {
                String title = element.select(STRONG_TXT).text();
                String link = element.select(TAG_A).attr(HREF);
                //https:/news/200%e... -> https://www.sciencetimes.co.kr/news/200%e.... 형태로 변경
                String replace = link.replace("https:", "https://www.sciencetimes.co.kr");

                articles.add(new Article(title, replace, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articles;
    }
}
