package ch.zuehlke.lambda.facilitator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.net.URI;

@Data
@EqualsAndHashCode(of = {"id"})
public class Game {
    private final String id;
    private final String title;
    @Setter
    private URI uri;
}
