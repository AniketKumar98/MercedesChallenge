package com.example.hackerearth.mercedeschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.hackerearth.mercedeschallenge"})
@EnableJpaRepositories("com.example.hackerearth.mercedeschallenge.repository")
public class MercedeschallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercedeschallengeApplication.class, args);
	}

}
