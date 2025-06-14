package tn.esprit.films.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.films.config.StudioFeignConfig;
import tn.esprit.films.service.dto.StudioResponse;

import java.util.List;


@FeignClient(
        name = "studio",
        path = "/studios",
        configuration = StudioFeignConfig.class
)
public interface StudioClient {
    @GetMapping("/{id}")
    StudioResponse getStudioById(@PathVariable("id") Long id);
    @GetMapping
    List<StudioResponse> getAllStudios();
}

