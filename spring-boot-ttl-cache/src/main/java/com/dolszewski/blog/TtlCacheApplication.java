package com.dolszewski.blog;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCaching
public class TtlCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtlCacheApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        CaffeineCache messageCache = buildCache("messages", ticker, 30);
        CaffeineCache notificationCache = buildCache("notifications", ticker, 60);

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(messageCache, notificationCache));
        return manager;
    }

    private CaffeineCache buildCache(String name, Ticker ticker, int minutesToExpire) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                    .expireAfterWrite(minutesToExpire, TimeUnit.MINUTES)
                    .maximumSize(100)
                    .ticker(ticker)
                    .build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

}
