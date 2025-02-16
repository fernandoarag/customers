package br.com.fiap.postech.customermanagement.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("public-api")
            .pathsToMatch("/**")
            .build();
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Customers API")
                .version("v3")
                .description("Customers API - v1"));
    }
}
