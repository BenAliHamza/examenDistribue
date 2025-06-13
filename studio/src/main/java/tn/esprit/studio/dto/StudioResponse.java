package tn.esprit.studio.dto;

import lombok.*;

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
}