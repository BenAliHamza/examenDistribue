package tn.esprit.films.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.OpenApiCustomizer;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("films Microservice API")
                        .version("1.0")
                        .description("API for managing films"));
    }

    @Bean
    public OpenApiCustomizer removeServerInfo() {
        return openApi -> {
            System.out.println("✅ removeServerInfo() called — removing servers from OpenAPI");
            openApi.setServers(null);
        };
    }
}
