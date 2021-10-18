package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateMeetingDTO;
import ch.zuehlke.lambda.facilitator.dto.MeetingDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MeetingService {

    Collection<MeetingDTO> getMeetings();

    MeetingDTO getMeeting(String id) throws NotFoundException;

    void updateMeeting(MeetingDTO meetingDTO) throws NotFoundException;

    String createMeeting(CreateMeetingDTO createMeetingDTO);

    void deleteMeeting(String id);
}
