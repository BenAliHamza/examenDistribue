package tn.esprit.films.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.films.service.FilmService;
import tn.esprit.films.service.dto.FilmRequest;
import tn.esprit.films.service.dto.FilmResponse;
import tn.esprit.sharedlogging.utils.LoggerFactoryUtil;
import tn.esprit.sharedlogging.interfaces.CustomLogger;

import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final CustomLogger logger = LoggerFactoryUtil.getLogger(FilmController.class);

    @PostMapping
    public ResponseEntity<FilmResponse> createFilm(@RequestBody FilmRequest request) {
        logger.info("CONTROLLER", "Creating new film: {}", request.getTitle());
        FilmResponse response = filmService.createFilm(request);
        logger.debug("CONTROLLER", "Created film with ID: {}", response.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilmResponse>> getAllFilms() {
        logger.info("CONTROLLER", "Fetching all films");
        List<FilmResponse> films = filmService.getAllFilms();
        logger.debug("CONTROLLER", "Found {} films", films.size());
        return ResponseEntity.ok(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable String id) {
        logger.info("CONTROLLER", "Fetching film by ID: {}", id);
        FilmResponse response = filmService.getFilmById(id);
        logger.debug("CONTROLLER", "Found film: {}", response.getTitle());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponse> updateFilm(
            @PathVariable String id,
            @RequestBody FilmRequest request
    ) {
        logger.info("CONTROLLER", "Updating film ID: {}", id);
        FilmResponse response = filmService.updateFilm(id, request);
        logger.debug("CONTROLLER", "Updated film: {}", response.getTitle());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String id) {
        logger.info("CONTROLLER", "Deleting film ID: {}", id);
        filmService.deleteFilm(id);
        logger.debug("CONTROLLER", "Deleted film ID: {}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-studio/{studioId}")
    public ResponseEntity<List<FilmResponse>> getFilmsByStudio(
            @PathVariable String studioId) {
        logger.info("CONTROLLER", "Fetching films for studio ID: {}", studioId);
        List<FilmResponse> films = filmService.getFilmsByStudioId(studioId);
        logger.debug("CONTROLLER", "Found {} films for studio {}", films.size(), studioId);
        return ResponseEntity.ok(films);
    }
}