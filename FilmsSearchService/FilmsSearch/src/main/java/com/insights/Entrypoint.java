package com.insights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Entrypoint {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Entrypoint.class, args);
    }
}
