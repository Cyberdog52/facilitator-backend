package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateMeetingDTO;
import ch.zuehlke.lambda.facilitator.dto.MeetingDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeetingServiceMock implements MeetingService {

    private static final List<MeetingDTO> meetings = new ArrayList<>(List.of(
            new MeetingDTO("1", 1632831652840L, "1", "1", new ArrayList<>(), new HashMap<>()),
            new MeetingDTO("2", 1317427200000L, "2", "2", List.of("1", "2"), Map.of("1", "DECLINED")),
            new MeetingDTO("3", 2232164600000L, null, null, null, null)
    ));

    @Override
    public Collection<MeetingDTO> getMeetings() {
        return meetings;
    }

    @Override
    public MeetingDTO getMeeting(String id) {
        return meetings.stream()
                .filter(meetingDTO -> meetingDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find meeting with id " + id));
    }

    @Override
    public void updateMeeting(MeetingDTO meetingDTO) throws NotFoundException {
        MeetingDTO meetingToReplace = this.getMeeting(meetingDTO.getId());
        Collections.replaceAll(meetings, meetingToReplace, meetingDTO);
    }

    @Override
    public void createMeeting(CreateMeetingDTO createMeetingDTO) {
        meetings.add(new MeetingDTO(UUID.randomUUID().toString(), createMeetingDTO.getTimeInMillis(), createMeetingDTO.getGameId(), createMeetingDTO.getRoomId(), createMeetingDTO.getTopicIds(), createMeetingDTO.getMemberIdReplyMap()));
    }

    @Override
    public void deleteMeeting(String id) {
        meetings.removeIf(meetingDTO -> meetingDTO.getId().equals(id));
    }
}
