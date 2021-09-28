package ch.zuehlke.lambda.facilitator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class TopicDTO {
    private final String id;
    private final String title;
    private final String description;
    private final String assigneeId;
}
