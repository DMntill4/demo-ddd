package com.backintro.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.backintro")
public class BackIntroApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackIntroApplication.class, args);
    }
}
