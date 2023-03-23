package com.ITApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
public class ItManagementApplication {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ItManagementApplication.class, args);
	}

}
