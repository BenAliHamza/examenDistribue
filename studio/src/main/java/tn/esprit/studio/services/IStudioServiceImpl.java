// tn/esprit/studio/services/StudioServiceImpl.java
package tn.esprit.studio.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.entities.Studio;
import tn.esprit.studio.repositories.StudioRepository;
import tn.esprit.studio.services.mappers.StudioMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IStudioServiceImpl implements IStudioService {

    private final StudioRepository studioRepository;

    @Override
    public StudioResponse create(StudioRequest request) {
        Studio studio = StudioMapper.toEntity(request);
        return StudioMapper.toDto(studioRepository.save(studio));
    }

    @Override
    public StudioResponse update(Long id, StudioRequest request) {
        Studio existing = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio not found"));

        existing.setName(request.getName());
        existing.setLocation(request.getLocation());
        existing.setDescription(request.getDescription());

        return StudioMapper.toDto(studioRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        studioRepository.deleteById(id);
    }

    @Override
    public StudioResponse getById(Long id) {
        return studioRepository.findById(id)
                .map(StudioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Studio not found"));
    }

    @Override
    public List<StudioResponse> getAll() {
        return studioRepository.findAll()
                .stream()
                .map(StudioMapper::toDto)
                .collect(Collectors.toList());
    }
}