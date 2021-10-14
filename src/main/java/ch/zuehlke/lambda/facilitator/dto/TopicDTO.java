package ch.zuehlke.lambda.facilitator.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class TopicDTO {
    private String id;
    private String title;
    private String description;
    private String assigneeId;
}
