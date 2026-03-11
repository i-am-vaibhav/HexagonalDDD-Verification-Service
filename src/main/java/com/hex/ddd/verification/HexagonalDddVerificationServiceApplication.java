package com.hex.ddd.verification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hex.ddd.verification.infrastructure.adapters.out.persistence"})
@EntityScan(basePackages = {"com.hex.ddd.verification.infrastructure.adapters.out.persistence"})
public class HexagonalDddVerificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalDddVerificationServiceApplication.class, args);
	}

}
