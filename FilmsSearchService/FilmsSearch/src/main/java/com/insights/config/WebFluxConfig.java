package com.insights.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/*
* Setting up the application to be working in Webflux mode
*/
@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
}

