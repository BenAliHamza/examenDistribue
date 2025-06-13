package tn.esprit.studio.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.entities.Studio;
import tn.esprit.studio.repositories.StudioRepository;
import tn.esprit.studio.services.mappers.StudioMapper;
import tn.esprit.sharedlogging.utils.LoggerFactoryUtil;
import tn.esprit.sharedlogging.interfaces.CustomLogger;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IStudioServiceImpl implements IStudioService {

    private final StudioRepository studioRepository;
    private final CustomLogger logger = LoggerFactoryUtil.getLogger(IStudioServiceImpl.class);

    @Override
    public StudioResponse create(StudioRequest request) {
        logger.info("SERVICE", "Creating studio: {}", request.getName());
        Studio studio = StudioMapper.toEntity(request);
        studio = studioRepository.save(studio);
        logger.debug("SERVICE", "Created studio ID: {}", studio.getId());
        return StudioMapper.toDto(studio);
    }

    @Override
    public StudioResponse update(Long id, StudioRequest request) {
        logger.info("SERVICE", "Updating studio ID: {}", id);
        Studio existing = studioRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("SERVICE", "Studio not found: {}", null, id);
                    return new RuntimeException("Studio not found");
                });

        logger.debug("SERVICE", "Updating studio: {}", existing.getName());
        existing.setName(request.getName());
        existing.setLocation(request.getLocation());
        existing.setDescription(request.getDescription());

        // Update film references if provided
        if(request.getFilmIds() != null) {
            logger.debug("SERVICE", "Updating {} film references", request.getFilmIds().size());
            existing.setFilmIds(request.getFilmIds());
        }

        Studio updatedStudio = studioRepository.save(existing);
        logger.debug("SERVICE", "Updated studio ID: {}", updatedStudio.getId());
        return StudioMapper.toDto(updatedStudio);
    }

    @Override
    public void delete(Long id) {
        logger.info("SERVICE", "Deleting studio ID: {}", id);
        if (!studioRepository.existsById(id)) {
            logger.error("SERVICE", "Studio not found for deletion: {}", null, id);
            throw new RuntimeException("Studio not found");
        }
        studioRepository.deleteById(id);
        logger.debug("SERVICE", "Deleted studio ID: {}", id);
    }

    @Override
    public StudioResponse getById(Long id) {
        logger.info("SERVICE", "Fetching studio by ID: {}", id);
        return studioRepository.findById(id)
                .map(studio -> {
                    logger.debug("SERVICE", "Found studio: {}", studio.getName());
                    return StudioMapper.toDto(studio);
                })
                .orElseThrow(() -> {
                    logger.error("SERVICE", "Studio not found: {}", null, id);
                    return new RuntimeException("Studio not found");
                });
    }

    @Override
    public List<StudioResponse> getAll() {
        logger.info("SERVICE", "Fetching all studios");
        List<StudioResponse> studios = studioRepository.findAll()
                .stream()
                .map(StudioMapper::toDto)
                .collect(Collectors.toList());
        logger.debug("SERVICE", "Found {} studios", studios.size());
        return studios;
    }
}