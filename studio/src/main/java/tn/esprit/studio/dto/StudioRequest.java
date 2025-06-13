// tn/esprit/studio/dto/StudioRequest.java
package tn.esprit.studio.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudioRequest {
    private String name;
    private String location;
    private String description;

    @Builder.Default
    private List<Long> filmIds = new ArrayList<>(); // Accept film IDs from client
}