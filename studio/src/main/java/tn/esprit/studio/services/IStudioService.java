package tn.esprit.studio.services;

import tn.esprit.studio.dto.StudioRequest;
import tn.esprit.studio.dto.StudioResponse;
import tn.esprit.studio.entities.Studio;

import java.util.List;

public interface IStudioService {

        StudioResponse create(StudioRequest request);
        StudioResponse update(Long id, StudioRequest request);
        void delete(Long id);
        StudioResponse getById(Long id);
        List<StudioResponse> getAll();

}
