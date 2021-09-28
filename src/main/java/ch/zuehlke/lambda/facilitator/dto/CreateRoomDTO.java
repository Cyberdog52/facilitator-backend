package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;

@Data
public class CreateRoomDTO {
    private final String name;
    private final int capacity;
}
