package com.conichi.technicaltest.config;

import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class CloudmersiveConfig {

    @Bean
    public void getApiKey() {
        ApiKeyAuth apiKey = (ApiKeyAuth) Configuration.getDefaultApiClient().getAuthentication("Apikey");
        apiKey.setApiKey("43c75c05-2750-4ed3-ad7c-774307face42");
    }

}
