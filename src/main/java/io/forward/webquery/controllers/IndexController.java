package io.forward.webquery.controllers;

import io.forward.webquery.model.Query;
import io.forward.webquery.model.ResultSet;
import io.forward.webquery.model.Tag;
import io.forward.webquery.parser.Parser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public final class IndexController {

    @RequestMapping("/query")
    public ResultSet index(@RequestBody Query query) {
        log.info("Fetching document");
        final List<Tag> results = extractFromWebPage(query.getUri(), query.getQuery());
        return new ResultSet(results);
    }

    @RequestMapping("/")
    public ResultSet index(@RequestParam String query) {
        log.info("Fetching document");
        final String uri = "https://spring.io/guides/gs/actuator-service/";
        final List<Tag> results = extractFromWebPage(uri, query);
        return new ResultSet(results);
    }

    private List<Tag> extractFromWebPage(String uri, String query) {
        String result = getPage(uri);
        Parser parser = new Parser(result);
        return parser.query(query);
    }

    private String getPage(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
