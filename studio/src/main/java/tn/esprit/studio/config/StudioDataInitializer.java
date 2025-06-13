// tn/esprit/studio/config/StudioDataInitializer.java
package tn.esprit.studio.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import tn.esprit.studio.entities.Studio;
import tn.esprit.studio.repositories.StudioRepository;

@Configuration
@RequiredArgsConstructor
public class StudioDataInitializer {

    private final StudioRepository studioRepository;

    @PostConstruct
    public void initData() {
        if (studioRepository.count() == 0) {
            Studio studio1 = Studio.builder()
                    .name("Pixar Animation Studios")
                    .location("Emeryville, California, USA")
                    .description("Leader in computer-animated films")
                    .build();

            Studio studio2 = Studio.builder()
                    .name("Studio Ghibli")
                    .location("Koganei, Tokyo, Japan")
                    .description("Japanese animation film studio")
                    .build();

            Studio studio3 = Studio.builder()
                    .name("Marvel Studios")
                    .location("Burbank, California, USA")
                    .description("American film and television studio")
                    .build();

            studioRepository.save(studio1);
            studioRepository.save(studio2);
            studioRepository.save(studio3);

            System.out.println("### Studio dummy data created ###");
        }
    }
}