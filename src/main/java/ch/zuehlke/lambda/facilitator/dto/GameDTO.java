package ch.zuehlke.lambda.facilitator.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class GameDTO {
    private String id;
    private String title;
    private String description;
    private String uri;
}
