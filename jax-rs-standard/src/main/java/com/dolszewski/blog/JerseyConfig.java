package com.dolszewski.blog;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile(Profiles.JERSEY)
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(SampleResource.class);
    }

}
