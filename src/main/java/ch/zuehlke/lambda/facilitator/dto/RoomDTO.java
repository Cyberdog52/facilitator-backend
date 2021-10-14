package ch.zuehlke.lambda.facilitator.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class RoomDTO {
    private String id;
    private String name;
    private int capacity;
}
