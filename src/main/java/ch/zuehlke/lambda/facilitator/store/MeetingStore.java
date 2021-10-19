package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Meeting;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;

import java.util.Collection;

public interface MeetingStore {

    Collection<Meeting> getMeetings();

    Meeting getMeeting(String id) throws NotFoundException;

    void updateMeeting(Meeting meeting) throws NotFoundException;

    void createMeeting(Meeting meeting);

    void deleteMeeting(String id);
}
