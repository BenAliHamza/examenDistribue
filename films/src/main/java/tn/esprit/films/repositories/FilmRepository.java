package tn.esprit.films.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.films.entities.Film;
import tn.esprit.films.service.dto.FilmResponse;

import java.util.List;


@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    List<Film> findByStudioId(String studioId);
}