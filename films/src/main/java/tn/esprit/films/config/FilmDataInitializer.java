package tn.esprit.films.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import tn.esprit.films.entities.Film;
import tn.esprit.films.repositories.FilmRepository;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class FilmDataInitializer {

    private final FilmRepository filmRepository;

    @PostConstruct
    public void initData() {
        if (filmRepository.count() == 0) {
            // Note: studioIds should match actual IDs from Studio service
            Film film1 = Film.builder()
                    .title("Toy Story")
                    .director("John Lasseter")
                    .releaseDate(LocalDate.of(1995, 11, 22))
                    .studioId("1") // Matches Pixar ID
                    .genre("Animation")
                    .duration(81)
                    .build();

            Film film2 = Film.builder()
                    .title("Spirited Away")
                    .director("Hayao Miyazaki")
                    .releaseDate(LocalDate.of(2001, 7, 20))
                    .studioId("2") // Matches Studio Ghibli ID
                    .genre("Fantasy")
                    .duration(125)
                    .build();

            Film film3 = Film.builder()
                    .title("Avengers: Endgame")
                    .director("Anthony Russo")
                    .releaseDate(LocalDate.of(2019, 4, 26))
                    .studioId("3") // Matches Marvel Studios ID
                    .genre("Superhero")
                    .duration(181)
                    .build();

            filmRepository.save(film1);
            filmRepository.save(film2);
            filmRepository.save(film3);

            System.out.println("### Film dummy data created ###");
        }
    }
}