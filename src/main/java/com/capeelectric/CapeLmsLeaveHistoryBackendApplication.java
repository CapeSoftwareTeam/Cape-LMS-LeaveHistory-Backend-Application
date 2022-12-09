package com.capeelectric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CapeLmsLeaveHistoryBackendApplication {

	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(CapeLmsLeaveHistoryBackendApplication.class, args);
	}

}
