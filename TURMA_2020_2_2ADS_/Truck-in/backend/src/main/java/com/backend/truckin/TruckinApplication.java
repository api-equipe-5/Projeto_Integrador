package com.backend.truckin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TruckinApplication {
	public static void main(String[] args) {
		SpringApplication.run(TruckinApplication.class, args);
	}
}
