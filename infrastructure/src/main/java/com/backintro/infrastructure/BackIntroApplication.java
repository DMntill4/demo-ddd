package com.backintro.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.backintro")
@EnableJpaRepositories(basePackages = "com.backintro.infrastructure")
public class BackIntroApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackIntroApplication.class, args);
    }
}
