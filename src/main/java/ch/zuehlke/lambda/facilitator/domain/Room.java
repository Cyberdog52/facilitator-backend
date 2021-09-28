package ch.zuehlke.lambda.facilitator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public class Room {
    private final String id;
    private final String name;
    private final int capacity;
}
