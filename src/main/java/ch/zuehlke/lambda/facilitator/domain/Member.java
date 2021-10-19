package ch.zuehlke.lambda.facilitator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Member {
    private final String id;
    private final String name;
    private final Role role;
}
