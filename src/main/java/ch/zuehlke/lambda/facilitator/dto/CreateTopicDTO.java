package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;

@Data
public class CreateTopicDTO {
    private final String title;
    private final String description;
    private final String assigneeId;
}
