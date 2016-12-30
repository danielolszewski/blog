package com.dolszewski.blog;

import com.github.benmanes.caffeine.cache.Ticker;
import com.google.common.testing.FakeTicker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageRepositoryTest {

    @Configuration
    @Import(TtlCacheApplication.class)
    public static class TestConfig {

        static FakeTicker fakeTicker = new FakeTicker();

        @Bean
        public Ticker ticker() {
            return fakeTicker::read;
        }

    }

    private static final long MESSAGE_ID = 1;
    private static final long NOTIFICATION_ID = 2;

    @SpyBean
    private RestTemplate restTemplate;
    @Autowired
    private ForeignEndpointGateway foreignEndpointGateway;

    @Before
    public void setUp() throws Exception {
        Message message = stubMessage(MESSAGE_ID);
        Notification notification = stubNotification(NOTIFICATION_ID);
        doReturn(message)
                .when(restTemplate)
                .getForObject(anyString(), eq(Message.class));
        doReturn(notification)
                .when(restTemplate)
                .getForObject(anyString(), eq(Notification.class));
    }

    @Test
    public void shouldUseCachesWithDifferentTTL() throws Exception {
        // 0 minutes
        foreignEndpointGateway.findMessage(MESSAGE_ID);
        foreignEndpointGateway.findNotification(NOTIFICATION_ID);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Message.class));
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Notification.class));
        // after 5 minutes
        TestConfig.fakeTicker.advance(5, TimeUnit.MINUTES);
        foreignEndpointGateway.findMessage(MESSAGE_ID);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Message.class));
        // after 35 minutes
        TestConfig.fakeTicker.advance(30, TimeUnit.MINUTES);
        foreignEndpointGateway.findMessage(MESSAGE_ID);
        foreignEndpointGateway.findNotification(NOTIFICATION_ID);
        verify(restTemplate, times(2)).getForObject(anyString(), eq(Message.class));
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Notification.class));
        // after 65 minutes
        TestConfig.fakeTicker.advance(30, TimeUnit.MINUTES);
        foreignEndpointGateway.findNotification(NOTIFICATION_ID);
        verify(restTemplate, times(2)).getForObject(anyString(), eq(Notification.class));
    }

    private Notification stubNotification(long id) {
        return new Notification(id, "Some text", LocalDateTime.now());
    }

    private Message stubMessage(long id) {
        return new Message(id, "Some subject", "Some content");
    }

}