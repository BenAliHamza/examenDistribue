package tn.esprit.films.service.mappers;

import tn.esprit.films.entities.Film;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;

public class FilmMapper {
    public static FilmResponse toResponse(Film film) {
        return FilmResponse.builder()
                .id(film.getId())
                .title(film.getTitle())
                .director(film.getDirector())
                .releaseDate(film.getReleaseDate())
                .studioId(film.getStudioId())
                .genre(film.getGenre())
                .duration(film.getDuration())
                .createdAt(film.getCreatedAt())
                .updatedAt(film.getUpdatedAt())
                .build();
    }

    public static Film toEntity(FilmRequest request) {
        return Film.builder()
                .title(request.getTitle())
                .director(request.getDirector())
                .releaseDate(request.getReleaseDate())
                .studioId(request.getStudioId())
                .genre(request.getGenre())
                .duration(request.getDuration())
                .build();
    }
}