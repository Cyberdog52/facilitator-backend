package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;

@Data
public class CreateMemberDTO {
    private final String name;
    private final String role;
}
