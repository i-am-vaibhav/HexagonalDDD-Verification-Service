package com.hex.ddd.verification.infrastructure.config;

import com.hex.ddd.verification.infrastructure.mappers.VerificationMapper;
import com.hex.ddd.verification.infrastructure.mappers.VerificationMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public VerificationMapper verificationMapper(){
        return new VerificationMapperImpl();
    }
}
