package tn.esprit.studio.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.services.IStudioService;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
@RequiredArgsConstructor
public class StudioController {

    private final IStudioService studioService;

    @PostMapping
    public StudioResponse create(@RequestBody StudioRequest request) {
        return studioService.create(request);
    }

    @PutMapping("/{id}")
    public StudioResponse update(
            @PathVariable Long id,
            @RequestBody StudioRequest request
    ) {
        return studioService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studioService.delete(id);
    }

    @GetMapping("/{id}")
    public StudioResponse getById(@PathVariable Long id) {
        return studioService.getById(id);
    }

    @GetMapping
    public List<StudioResponse> getAll() {
        return studioService.getAll();
    }
}