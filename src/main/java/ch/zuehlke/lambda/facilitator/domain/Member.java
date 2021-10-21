package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Table
@Entity
public class Member {
    @Id
    private String id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
