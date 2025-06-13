// tn/esprit/studio/dto/StudioRequest.java
package tn.esprit.studio.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudioRequest {
    private String name;
    private String location;
    private String description;
}