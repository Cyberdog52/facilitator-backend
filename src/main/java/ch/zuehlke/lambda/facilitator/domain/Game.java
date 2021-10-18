package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import java.net.URI;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Game {
    private final String id;
    private final String title;
    private final String description;
    @Setter
    private URI uri;
}
