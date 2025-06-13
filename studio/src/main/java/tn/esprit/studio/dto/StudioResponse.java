package tn.esprit.studio.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudioResponse {
    private Long id;
    private String name;
    private String location;
    private String description;
    private List<Long> filmIds; // Return film IDs to client
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}