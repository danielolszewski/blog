package com.dolszewski.blog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class InitDemoWarInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        InitDemoApplication.addInitHooks(builder.application());
        return builder.sources(InitDemoApplication.class);
    }

}
