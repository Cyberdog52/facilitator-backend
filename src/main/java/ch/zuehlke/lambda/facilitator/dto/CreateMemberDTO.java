package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateMemberDTO {
    private String name;
    private String role;
}
