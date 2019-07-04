package io.forward.webquery.parser;

import io.forward.webquery.model.Tag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Parser {

    private String html;

    public Parser(String html) {
        this.html = html;
    }

    private Map<String, String> getAttributesMap(Element e) {
        Map<String, String> result = new HashMap<>();
        return e.attributes().asList()
                .stream()
                .reduce(result, (map, value) -> {
                    map.put(value.getKey(), value.getValue());
                    return map;
                }, (a, b) -> a);
    }

    public List<Tag> query(String query) {
        final Document doc = Jsoup.parse(html);
        return doc.select(query).stream().map(e -> {
            Map<String, String> attrs = this.getAttributesMap(e);
            return new Tag(e.tagName(), e.ownText(), attrs);
        }).collect(Collectors.toList());
    }
}
