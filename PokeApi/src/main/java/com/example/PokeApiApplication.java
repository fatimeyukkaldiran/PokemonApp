package com.example;

import com.example.service.WorkUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
		WorkUtils.getStartData();
	}

	@Bean
	public RestTemplate restTemplateBuilderr(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}
