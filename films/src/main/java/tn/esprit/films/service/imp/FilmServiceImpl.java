package tn.esprit.films.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.films.entities.Film;
import tn.esprit.films.repositories.FilmRepository;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;
import tn.esprit.films.service.mappers.FilmMapper;
import tn.esprit.sharedlogging.utils.LoggerFactoryUtil;
import tn.esprit.sharedlogging.interfaces.CustomLogger;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final CustomLogger logger = LoggerFactoryUtil.getLogger(FilmServiceImpl.class);

    @Override
    public FilmResponse createFilm(FilmRequest request) {
        logger.info("SERVICE", "Creating film: {}", request.getTitle());
        Film film = FilmMapper.toEntity(request);
        film = filmRepository.save(film);
        logger.debug("SERVICE", "Created film ID: {}", film.getId());
        return FilmMapper.toResponse(film);
    }

    @Override
    public List<FilmResponse> getAllFilms() {
        logger.info("SERVICE", "Fetching all films");
        List<FilmResponse> films = filmRepository.findAll()
                .stream()
                .map(FilmMapper::toResponse)
                .collect(Collectors.toList());
        logger.debug("SERVICE", "Found {} films", films.size());
        return films;
    }

    @Override
    public FilmResponse getFilmById(String id) {
        logger.info("SERVICE", "Fetching film by ID: {}", id);
        return filmRepository.findById(id)
                .map(film -> {
                    logger.debug("SERVICE", "Found film: {}", film.getTitle());
                    return FilmMapper.toResponse(film);
                })
                .orElseThrow(() -> {
                    logger.error("SERVICE", "Film not found: {}", null, id);
                    return new RuntimeException("Film not found");
                });
    }

    @Override
    public FilmResponse updateFilm(String id, FilmRequest request) {
        logger.info("SERVICE", "Updating film ID: {}", id);
        Film existingFilm = filmRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("SERVICE", "Film not found for update: {}", null, id);
                    return new RuntimeException("Film not found");
                });

        logger.debug("SERVICE", "Updating film: {}", existingFilm.getTitle());
        existingFilm.setTitle(request.getTitle());
        existingFilm.setDirector(request.getDirector());
        existingFilm.setReleaseDate(request.getReleaseDate());
        existingFilm.setStudioId(request.getStudioId());
        existingFilm.setGenre(request.getGenre());
        existingFilm.setDuration(request.getDuration());

        Film updatedFilm = filmRepository.save(existingFilm);
        logger.debug("SERVICE", "Updated film ID: {}", updatedFilm.getId());
        return FilmMapper.toResponse(updatedFilm);
    }

    @Override
    public void deleteFilm(String id) {
        logger.info("SERVICE", "Deleting film ID: {}", id);
        if (!filmRepository.existsById(id)) {
            logger.error("SERVICE", "Film not found for deletion: {}", null, id);
            throw new RuntimeException("Film not found");
        }
        filmRepository.deleteById(id);
        logger.debug("SERVICE", "Deleted film ID: {}", id);
    }

    @Override
    public List<FilmResponse> getFilmsByStudioId(String studioId) {
        logger.info("SERVICE", "Fetching films for studio ID: {}", studioId);
        List<FilmResponse> films = filmRepository.findByStudioId(studioId)
                .stream()
                .map(FilmMapper::toResponse)
                .collect(Collectors.toList());
        logger.debug("SERVICE", "Found {} films for studio {}", films.size(), studioId);
        return films;
    }
}