package ch.zuehlke.lambda.facilitator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class MemberDTO {
    private final String id;
    private final String name;
    private final String role;
}
