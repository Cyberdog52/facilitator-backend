package ch.zuehlke.lambda.facilitator.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Data
@EqualsAndHashCode(of = {"id"})
public class Meeting {
    private final String id;
    @Setter
    private Date date;
    @Setter
    private Game game;
    @Setter
    private Room room;
    @Setter
    private Collection<Topic> topics;
    @Setter
    private Map<Member, Reply> memberReplyMap;
}
