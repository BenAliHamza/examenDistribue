package tn.esprit.studio.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Studio Microservice API")
                        .version("1.0")
                        .description("API for managing film studios"));
    }
}
