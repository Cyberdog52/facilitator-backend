package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Entity
@Table
public class Topic {
    @Id
    private String id;
    private String title;
    @Setter
    private String description;
    @Setter
    @OneToOne
    private Member assignee;
}
