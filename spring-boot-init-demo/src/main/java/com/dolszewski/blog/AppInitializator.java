package com.dolszewski.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializator {

    private static final Logger log = LoggerFactory.getLogger(AppInitializator.class);

    @PostConstruct
    private void init() {
        log.info("AppInitializator initialization logic ...");
        // ...
    }

}
