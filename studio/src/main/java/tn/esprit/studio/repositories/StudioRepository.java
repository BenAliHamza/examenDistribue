package tn.esprit.studio.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.studio.entities.Studio;


@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
}
