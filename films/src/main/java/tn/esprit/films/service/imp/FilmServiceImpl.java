// tn/esprit/films/service/imp/FilmServiceImpl.java
package tn.esprit.films.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.films.entities.Film;
import tn.esprit.films.repositories.FilmRepository;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;
import tn.esprit.films.service.mappers.FilmMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public FilmResponse createFilm(FilmRequest request) {
        Film film = FilmMapper.toEntity(request);
        return FilmMapper.toResponse(filmRepository.save(film));
    }

    @Override
    public List<FilmResponse> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(FilmMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FilmResponse getFilmById(String id) {
        return filmRepository.findById(id)
                .map(FilmMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Film not found"));
    }

    @Override
    public FilmResponse updateFilm(String id, FilmRequest request) {
        Film existingFilm = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));

        existingFilm.setTitle(request.getTitle());
        existingFilm.setDirector(request.getDirector());
        existingFilm.setReleaseDate(request.getReleaseDate());
        existingFilm.setStudioId(request.getStudioId());
        existingFilm.setGenre(request.getGenre());
        existingFilm.setDuration(request.getDuration());

        return FilmMapper.toResponse(filmRepository.save(existingFilm));
    }

    @Override
    public void deleteFilm(String id) {
        filmRepository.deleteById(id);
    }
}