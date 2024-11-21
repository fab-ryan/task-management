package com.task_management.config;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        Server server;
        return new OpenAPI()
                .components(new io.swagger.v3.oas.models.Components().securitySchemes(
                        new java.util.HashMap<String, io.swagger.v3.oas.models.security.SecurityScheme>() {
                            {
                                put("bearer-key", new io.swagger.v3.oas.models.security.SecurityScheme()
                                        .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT"));
                            }
                        }))
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Task Management Application")
                        .version("1.0")
                        .description("Task Management Application"));
    }
}
