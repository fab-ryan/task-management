package com.task_management.config;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        Server server;
        return new OpenAPI()
                .components(new io.swagger.v3.oas.models.Components().securitySchemes(
                        new java.util.HashMap<String, SecurityScheme>() {
                            {
                                put("bearer-key", new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
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
