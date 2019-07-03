package io.forward.webquery.controllers;

import io.forward.webquery.parser.Parser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public String index() {
        log.info("Fetching document");
        Parser parser = new Parser("<a>Hello, World!</a>");
        return parser.query("a");
    }
}
