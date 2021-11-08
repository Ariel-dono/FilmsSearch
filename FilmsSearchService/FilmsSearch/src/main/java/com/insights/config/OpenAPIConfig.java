package com.insights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class OpenAPIConfig {
    @Bean
    public Docket api() {
        ApiInfo apiInfo = new ApiInfoBuilder().description("RESTFul service provisioning search capabilities on top of decentralized datasets").title("FilmsSearch").contact(new Contact("Ariel Herrera", "", "carherrera@outlook.es")).build();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.insights.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}