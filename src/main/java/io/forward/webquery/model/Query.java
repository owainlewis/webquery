package io.forward.webquery.model;

import lombok.Getter;
import lombok.Setter;

public final class Query {
    @Getter
    @Setter
    private String query;

    @Getter
    @Setter
    private String uri;

    public Query () {
    }

    public Query(String uri, String query) {
        this.uri = uri;
        this.query = query;
    }
}
