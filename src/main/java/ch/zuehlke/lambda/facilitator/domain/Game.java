package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.URI;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Table
@Entity
public class Game {
    @Id
    private String id;
    private String title;
    private String description;
    @Setter
    private URI uri;
}
