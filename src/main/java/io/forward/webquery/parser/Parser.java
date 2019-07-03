package io.forward.webquery.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {

    private String html;

    public Parser(String html) {
        this.html = html;
    }

    public String query(String query) {
        Document doc = Jsoup.parse(this.html);
        Element result = doc.select(query).first();

        return result.text();

    }
}
