package tn.esprit.films.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.films.entities.Film;



@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
}