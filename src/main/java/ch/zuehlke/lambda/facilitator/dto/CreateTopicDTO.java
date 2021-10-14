package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateTopicDTO {
    private String title;
    private String description;
    private String assigneeId;
}
