package tn.esprit.studio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Enable automatic timestamp handling
public class StudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudioApplication.class, args);
    }

}
