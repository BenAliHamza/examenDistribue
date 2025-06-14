package tn.esprit.films.service.imp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.films.service.StudioClient;
import tn.esprit.films.service.dto.StudioResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioIntegrationService {

    private final StudioClient studioClient;

    /** Récupère un studio… sauf si le réseau burn 🔥 */
    @CircuitBreaker(name = "studioService", fallbackMethod = "fallbackStudio")
    @Retry(name = "studioService") // 3 tentatives par défaut
    public StudioResponse findStudio(long id) {
        return studioClient.getStudioById(id);
    }

    /** Méthode de repli */
    private StudioResponse fallbackStudio(long id, Throwable t) {
        return StudioResponse.builder()
                .id(0L)
                .name("UNKNOWN")
                .location("N/A")
                .description("Fallback - service indisponible")
                .filmIds(List.of())
                .build();
    }
}
