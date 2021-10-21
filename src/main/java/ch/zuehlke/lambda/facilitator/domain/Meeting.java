package ch.zuehlke.lambda.facilitator.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Table
@Entity
public class Meeting {
    @Id
    private String id;
    @Setter
    private Date date;
    @Setter
    @OneToOne
    private Game game;
    @Setter
    @OneToOne
    private Room room;
    @Setter
    @OneToMany
    private Collection<Topic> topics;
    @Setter

    @ElementCollection
    @CollectionTable(name = "meetingMemberReply",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "id")
    @Column(name = "reply")
    private Map<Member, Reply> memberReplyMap;
}
