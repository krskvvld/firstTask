package org.karsakov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    static final String FIRST_PAGE = "https://www.booksite.ru/localtxt/gub/erm/an/guberman_i/gariki/1.htm";
    static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";

    public String fetchHtml(String url, String userAgent) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent)
                    .get();
            return doc.outerHtml();
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке страницы: " + e.getMessage());
            return null;
        }
    }

    public Elements extractPreElements(String html) {
        Document doc = Jsoup.parse(html);
        return doc.select("pre");
    }
}