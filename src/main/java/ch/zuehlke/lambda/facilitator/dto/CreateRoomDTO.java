package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateRoomDTO {
    private String name;
    private int capacity;
}
