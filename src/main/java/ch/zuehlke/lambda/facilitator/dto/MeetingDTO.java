package ch.zuehlke.lambda.facilitator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class MeetingDTO {
    private final String id;
    private final long timeInMillis;
    private final String gameId;
    private final String roomId;
    private final Collection<String> topicIds;
    private final Map<String, String> memberIdReplyMap;
}
