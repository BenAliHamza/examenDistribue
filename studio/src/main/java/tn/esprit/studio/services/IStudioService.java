package tn.esprit.studio.services;

import tn.esprit.studio.entities.Studio;

import java.util.List;

public interface IStudioService {

        Studio create(Studio studio);
        Studio update(Long id, Studio studio);
        void delete(Long id);
        Studio getById(Long id);
        List<Studio> getAll();

}
