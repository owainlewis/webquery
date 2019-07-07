package io.forward.webquery.controllers;

import io.forward.webquery.model.Query;
import io.forward.webquery.model.ResultSet;
import io.forward.webquery.model.Tag;
import io.forward.webquery.parser.Parser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@CacheConfig(cacheNames = {"query"})
@Api(value = "WebQuery", description = "WebQuery")
@RequestMapping("api/v1")
public class IndexController {
    @RequestMapping(path = "query", method = RequestMethod.POST, produces = "application/json")
    @Cacheable
    @ApiOperation(value = "Submit a search query")
    public ResultSet index(@RequestBody Query query) {
        final List<Tag> results = extractFromWebPage(query.getUri(), query.getSelector());
        return new ResultSet(results);
    }

    private List<Tag> extractFromWebPage(String uri, String selector) {
        log.info("Fetching document");
        String result = getPage(uri);
        Parser parser = new Parser(result);
        return parser.query(selector);
    }

    private String getPage(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
