package org.karsakov;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writeTextToFile(Elements preElements, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Element pre : preElements) {
                String text = cleanText(pre.ownText());
                if (!text.isEmpty()) {
                    writer.write(text + "\n\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private String cleanText(String text) {
        return text.replaceAll("[^А-Яа-яЁё0-9.,!?;:'\"()\\-–—\\[\\]{}«»<>…\\\\/@#%^&*+=_|~`$№\\s]|\\s*\\d+$", "").trim();
    }

//    private String cleanText(String text) {
//        return text
//                .replaceAll("\\s*\\d+$", "")
//                .lines()
//                .map(String::trim)
//                .map(line -> line.replaceAll("\\s{2,}", " "))
//                .filter(line -> !line.isBlank())
//                .reduce((line1, line2) -> line1 + "\n" + line2)
//                .orElse("");
//    }
}