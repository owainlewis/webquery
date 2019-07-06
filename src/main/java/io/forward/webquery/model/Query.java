package io.forward.webquery.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public final class Query {
    @Getter
    @Setter
    @NotNull
    private String query;

    @Getter
    @Setter
    @NotNull
    private String uri;

    public Query () {
    }

    public Query(String uri, String query) {
        this.uri = uri;
        this.query = query;
    }
}
