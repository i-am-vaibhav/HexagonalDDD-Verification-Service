package com.hex.ddd.verification.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import static tools.jackson.databind.cfg.DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
                return JsonMapper.builder()
                        .disable(WRITE_DATES_AS_TIMESTAMPS)
                        .build();
    }

}