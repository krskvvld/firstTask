package org.karsakov;

import org.jsoup.select.Elements;

import static org.karsakov.Parser.*;

public class Main {
public static void main(String[] args) {
        Parser parser = new Parser();
        Writer writer = new Writer();
        String html = parser.fetchHtml(FIRST_PAGE, USER_AGENT);

        if (html != null) {
            Elements preElements = parser.extractPreElements(html);
            writer.writeTextToFile(preElements, "notes.txt");
        }
    }
}