package com.test_6.Order.config;//package com.test_6.Order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient WebClient() {
        return WebClient.builder().build();
    }

    @Bean
    public WebClient inventoryWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8080/api/v1").build();
    }

    @Bean
    public WebClient productWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8082/api/v1").build();
    }
}
