package com.dolszewski.blog;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestEasyConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SampleResource.class);
        return classes;
    }

}
