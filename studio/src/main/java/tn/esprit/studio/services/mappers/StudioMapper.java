package tn.esprit.studio.services.mappers;

import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.entities.Studio;

public class StudioMapper {

    public static Studio toEntity(StudioRequest request) {
        return Studio.builder()
                .name(request.getName())
                .location(request.getLocation())
                .description(request.getDescription())
                .filmIds(request.getFilmIds()) // Map film IDs
                .build();
    }

    public static StudioResponse toDto(Studio studio) {
        return StudioResponse.builder()
                .id(studio.getId())
                .name(studio.getName())
                .location(studio.getLocation())
                .description(studio.getDescription())
                .filmIds(studio.getFilmIds()) // Map film IDs
                .createdAt(studio.getCreatedAt())
                .updatedAt(studio.getUpdatedAt())
                .build();
    }
}