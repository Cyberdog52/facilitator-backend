package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Meeting;
import ch.zuehlke.lambda.facilitator.domain.Reply;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.*;

@Service
public class MeetingStoreMock implements MeetingStore {

    private static final List<Meeting> meetings = new ArrayList<>(List.of(
            new Meeting("1", Date.from(Instant.now()), GameStoreMock.games.get(0), RoomStoreMock.rooms.get(0), new ArrayList<>(), new HashMap<>()),
            new Meeting("2", new Date(726828720000L), GameStoreMock.games.get(1), RoomStoreMock.rooms.get(1), List.of(TopicStoreMock.topics.get(0), TopicStoreMock.topics.get(1)), Map.of(MemberStoreMock.members.get(0), Reply.DECLINED)),
            new Meeting("3", new Date(946684861000L), null, null, null, null)
    ));

    @Override
    public Collection<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public Meeting getMeeting(String id) throws NotFoundException {
        return meetings.stream()
                .filter(meeting -> meeting.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find meeting with id " + id));
    }

    @Override
    public void updateMeeting(Meeting meeting) throws NotFoundException {
        Meeting meetingToReplace = this.getMeeting(meeting.getId());
        Collections.replaceAll(meetings, meetingToReplace, meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public void deleteMeeting(String id) {
        meetings.removeIf(meeting -> meeting.getId().equals(id));
    }
}
