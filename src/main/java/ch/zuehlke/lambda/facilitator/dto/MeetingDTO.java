package ch.zuehlke.lambda.facilitator.dto;

import lombok.*;

import java.util.Collection;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class MeetingDTO {
    private String id;
    private long timeInMillis;
    private String gameId;
    private String roomId;
    private Collection<String> topicIds;
    private Map<String, String> memberIdReplyMap;
}
