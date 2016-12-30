package com.dolszewski.blog;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class ForeignEndpointGateway {

    private RestTemplate restTemplate;

    ForeignEndpointGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("messages")
    public Message findMessage(long id) {
        String url = "http://somedomain.com/messages/" + id;
        return restTemplate.getForObject(url, Message.class);
    }

    @Cacheable("notifications")
    public Notification findNotification(long id) {
        String url = "http://somedomain.com/notifications/" + id;
        return restTemplate.getForObject(url, Notification.class);
    }

}