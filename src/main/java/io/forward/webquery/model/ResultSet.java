package io.forward.webquery.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public final class ResultSet {
    @Getter
    @Setter
    private List<Tag> elements;

    public ResultSet(List<Tag> elements) {
        this.elements = elements;
    }
}
