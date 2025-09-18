package com.curso.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return  GroupedOpenApi.builder()
                .group("Biblioteca")
                .pathsToMatch("/**")
                .packagesToScan("com.curso.resources")
                .build();
    }

    @Bean
    public OpenAPI cutonOpenApi(){
        return new OpenAPI().info(new Info().title("Biblioteca")
                                            .description("Biblioteca com livros")
                                            .version("1.0")
                                            .contact(new Contact().name("Curso Spring")
                                                                  .url("http:/github.com/curso-spring/Curso-Spring")
                                                                  .email("curso@curso.com.br")));
    }

}
