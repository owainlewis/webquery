package io.forward.webquery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
public class WebqueryApplication {
	public static void main(String[] args) {
	    log.info("Starting application");
		SpringApplication.run(WebqueryApplication.class, args);
	}
}
