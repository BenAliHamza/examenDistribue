package tn.esprit.films.service.mappers;


import tn.esprit.films.entities.Film;
import tn.esprit.films.service.dto.FilmDTO;

public class FilmMapper {
    public static FilmDTO toDTO(Film film) {
        return FilmDTO.builder()
                .id(film.getId())
                .title(film.getTitle())
                .director(film.getDirector())
                .releaseDate(film.getReleaseDate())
                .studioId(film.getStudioId())
                .genre(film.getGenre())
                .duration(film.getDuration())
                .build();
    }

    public static Film toEntity(FilmDTO filmDTO) {
        return Film.builder()
                .title(filmDTO.getTitle())
                .director(filmDTO.getDirector())
                .releaseDate(filmDTO.getReleaseDate())
                .studioId(filmDTO.getStudioId())
                .genre(filmDTO.getGenre())
                .duration(filmDTO.getDuration())
                .build();
    }
}