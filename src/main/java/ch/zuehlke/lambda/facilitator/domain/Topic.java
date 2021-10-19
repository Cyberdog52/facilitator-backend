package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class Topic {
    private final String id;
    private final String title;
    @Setter
    private String description;
    @Setter
    private Member assignee;
}
