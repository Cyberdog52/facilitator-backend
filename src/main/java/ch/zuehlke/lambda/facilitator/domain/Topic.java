package ch.zuehlke.lambda.facilitator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(of = {"id"})
public class Topic {
    private final String id;
    private final String title;
    @Setter
    private String description;
    @Setter
    private Member assignee;
}
