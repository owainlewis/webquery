package io.forward.webquery.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public final class Query {
    @Getter
    @Setter
    @NotNull
    private String uri;

    @Getter
    @Setter
    @NotNull
    private String selector;

    public Query () {
    }

    public Query(String uri, String selector) {
        this.uri = uri;
        this.selector = selector;
    }
}
