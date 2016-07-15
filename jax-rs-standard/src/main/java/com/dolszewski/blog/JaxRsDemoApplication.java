package com.dolszewski.blog;

import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class JaxRsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxRsDemoApplication.class, args);
    }

    @Profile(Profiles.RESTEASY)
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        Map<String, String> initParams = new HashMap<>();
        initParams.put("javax.ws.rs.Application", RestEasyConfig.class.getCanonicalName());
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterDispatcher());
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

}
