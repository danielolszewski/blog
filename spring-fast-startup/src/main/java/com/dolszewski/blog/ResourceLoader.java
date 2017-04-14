package com.dolszewski.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
class ResourceLoader {

    private static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);

    private List<Term> resources;

    @PostConstruct
    void initHeavyLoading() throws InterruptedException {
        log.info("Loading start");
        // time-consuming execution
        Thread.sleep(10_000);
        resources = loadResources();
        log.info("Loading end");
    }

    private List<Term> loadResources() {
        // load resources e.g. from local app resources or web service
        return new LinkedList<>();
    }

    List<Term> getResources() {
        return resources;
    }

    // ...

}
