package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Entity
@Table
public class Room {
    @Id
    private String id;
    private String name;
    private int capacity;
}
