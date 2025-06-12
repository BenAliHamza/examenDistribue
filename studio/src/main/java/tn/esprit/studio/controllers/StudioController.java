package tn.esprit.studio.controllers;


import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studio.entities.Studio;
import tn.esprit.studio.services.IStudioService;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
@RequiredArgsConstructor // This automatically generates a constructor with required fields
public class StudioController {

    private final IStudioService studioService;

    @PostMapping
    public Studio create(@RequestBody Studio studio) {
        return studioService.create(studio);
    }

    @PutMapping("/{id}")
    public Studio update(@PathVariable Long id, @RequestBody Studio studio) {
        return studioService.update(id, studio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studioService.delete(id);
    }

    @GetMapping("/{id}")
    public Studio getById(@PathVariable Long id) {
        return studioService.getById(id);
    }

    @GetMapping
    public List<Studio> getAll() {
        return studioService.getAll();
    }
}
