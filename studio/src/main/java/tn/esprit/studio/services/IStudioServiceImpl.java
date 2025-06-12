package tn.esprit.studio.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.studio.entities.Studio;
import tn.esprit.studio.repositories.StudioRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class IStudioServiceImpl implements IStudioService {

    private final StudioRepository studioRepository;

    @Override
    public Studio create(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public Studio update(Long id, Studio studio) {
        Studio existing = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio not found"));
        existing.setName(studio.getName());
        existing.setLocation(studio.getLocation());
        existing.setDescription(studio.getDescription());
        return studioRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        studioRepository.deleteById(id);
    }

    @Override
    public Studio getById(Long id) {
        return studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio not found"));
    }

    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }
}
