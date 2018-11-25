package com.dolszewski.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationListener;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class InitDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(AppInitializator.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(InitDemoApplication.class);
        addInitHooks(application);
        application.run(args);
    }

    static void addInitHooks(SpringApplication application) {
        application.addListeners((ApplicationListener<ApplicationStartingEvent>) event -> {
            System.out.println("ApplicationStartingEvent hook ...");
        });
        application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
            String version = event.getEnvironment().getProperty("java.runtime.version");
            log.info("Running with Java {}", version);
        });
        application.addListeners((ApplicationListener<ApplicationContextInitializedEvent>) event -> {
            log.info("ApplicationContextInitializedEvent hook ...");
        });
        application.addListeners((ApplicationListener<ApplicationPreparedEvent>) event -> {
            log.info("ApplicationPreparedEvent hook ...");
        });
        application.addListeners((ApplicationListener<ApplicationStartedEvent>) event -> {
            log.info("ApplicationStartedEvent hook ...");
        });
        application.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
            log.info("ApplicationReadyEvent hook ...");
        });
    }

    @PostConstruct
    private void init() {
        log.info("InitDemoApplication initialization logic ...");
        // ...
    }

}
