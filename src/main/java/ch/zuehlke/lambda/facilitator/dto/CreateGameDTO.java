package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateGameDTO {
    private String title;
    private String uri;
}
