package tn.esprit.studio.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.services.IStudioService;
import tn.esprit.sharedlogging.utils.LoggerFactoryUtil;
import tn.esprit.sharedlogging.interfaces.CustomLogger;

import java.util.List;

@RestController
@RequestMapping("/studios")
@RequiredArgsConstructor
public class StudioController {

    private final IStudioService studioService;
    private final CustomLogger logger = LoggerFactoryUtil.getLogger(StudioController.class);

    @PostMapping
    public StudioResponse create(@RequestBody StudioRequest request) {
        logger.info("CONTROLLER", "Creating studio: {}", request.getName());
        StudioResponse response = studioService.create(request);
        logger.debug("CONTROLLER", "Created studio ID: {}", response.getId());
        return response;
    }

    @PutMapping("/{id}")
    public StudioResponse update(
            @PathVariable Long id,
            @RequestBody StudioRequest request
    ) {
        logger.info("CONTROLLER", "Updating studio ID: {}", id);
        StudioResponse response = studioService.update(id, request);
        logger.debug("CONTROLLER", "Updated studio: {}", response.getName());
        return response;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        logger.info("CONTROLLER", "Deleting studio ID: {}", id);
        studioService.delete(id);
        logger.debug("CONTROLLER", "Deleted studio ID: {}", id);
    }

    @GetMapping("/{id}")
    public StudioResponse getById(@PathVariable Long id) {
        logger.info("CONTROLLER", "Fetching studio by ID: {}", id);
        StudioResponse response = studioService.getById(id);
        logger.debug("CONTROLLER", "Found studio: {}", response.getName());
        return response;
    }

    @GetMapping
    public List<StudioResponse> getAll() {
        logger.warn("CONTROLLER", "Fetching all studios");
        List<StudioResponse> studios = studioService.getAll();
        logger.debug("CONTROLLER", "Found {} studios", studios.size());
        return studios;
    }
}