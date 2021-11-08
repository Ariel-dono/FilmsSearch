package com.insights.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration // Marks the class as configuration class
@EnableWebFlux // Enables Webflux in our application
public class WebFluxConfig implements WebFluxConfigurer {
}

