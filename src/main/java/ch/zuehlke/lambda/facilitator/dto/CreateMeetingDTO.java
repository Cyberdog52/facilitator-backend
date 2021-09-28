package ch.zuehlke.lambda.facilitator.dto;

import lombok.Data;

import java.util.Collection;
import java.util.Map;

@Data
public class CreateMeetingDTO {
    private final long timeInMillis;
    private final String gameId;
    private final String roomId;
    private final Collection<String> topicIds;
    private final Map<String, String> memberIdReplyMap;
}
