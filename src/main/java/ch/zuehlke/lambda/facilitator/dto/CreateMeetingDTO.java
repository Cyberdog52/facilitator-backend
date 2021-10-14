package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@NoArgsConstructor
@Data
public class CreateMeetingDTO {
    private long timeInMillis;
    private String gameId;
    private String roomId;
    private Collection<String> topicIds;
    private Map<String, String> memberIdReplyMap;
}
