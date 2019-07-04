package io.forward.webquery.model;

import lombok.Getter;

import java.util.Map;

public final class Tag {
    @Getter
    private String tag;

    @Getter
    private String text;

    @Getter
    private Map<String, String> attributes;

    public Tag(String tag, String text, Map<String, String> attributes) {
        this.tag = tag;
        this.text = text;
        this.attributes = attributes;
    }
}
