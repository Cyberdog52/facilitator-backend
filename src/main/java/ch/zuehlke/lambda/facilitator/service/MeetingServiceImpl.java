package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.domain.*;
import ch.zuehlke.lambda.facilitator.dto.CreateMeetingDTO;
import ch.zuehlke.lambda.facilitator.dto.MeetingDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.mapper.MeetingMapper;
import ch.zuehlke.lambda.facilitator.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingStore meetingStore;
    private final MemberStore memberStore;
    private final GameStore gameStore;
    private final RoomStore roomStore;
    private final TopicStore topicStore;

    @Autowired
    public MeetingServiceImpl(MeetingStore meetingStore, MemberStore memberStore, GameStore gameStore, RoomStore roomStore, TopicStore topicStore) {
        this.meetingStore = meetingStore;
        this.memberStore = memberStore;
        this.gameStore = gameStore;
        this.roomStore = roomStore;
        this.topicStore = topicStore;
    }

    @Override
    public Collection<MeetingDTO> getMeetings() {
        Collection<Meeting> meetings = meetingStore.getMeetings();
        return MeetingMapper.map(meetings);
    }

    @Override
    public MeetingDTO getMeeting(String id) {
        Meeting meeting = meetingStore.getMeeting(id);
        return MeetingMapper.map(meeting);
    }

    @Override
    public void updateMeeting(MeetingDTO meetingDTO) throws NotFoundException {
        Game game = meetingDTO.getGameId() == null ? null : gameStore.getGame(meetingDTO.getGameId());
        Room room = meetingDTO.getRoomId() == null ? null : roomStore.getRoom(meetingDTO.getRoomId());

        List<Topic> topicsForMeeting = meetingDTO.getTopicIds().stream()
                .map(topicStore::getTopic)
                .collect(Collectors.toList());

        Set<Member> membersForMeeting = meetingDTO.getMemberIdReplyMap()
                .keySet().stream()
                .map(memberStore::getMember)
                .collect(Collectors.toSet());

        Meeting meeting = MeetingMapper.map(meetingDTO, game, room, topicsForMeeting, membersForMeeting);
        meetingStore.updateMeeting(meeting);
    }

    @Override
    public String createMeeting(CreateMeetingDTO createMeetingDTO) {
        Game game = createMeetingDTO.getGameId() == null ? null : gameStore.getGame(createMeetingDTO.getGameId());
        Room room = createMeetingDTO.getRoomId() == null ? null : roomStore.getRoom(createMeetingDTO.getRoomId());

        List<Topic> topicsForMeeting = createMeetingDTO.getTopicIds().stream()
                .map(topicStore::getTopic)
                .collect(Collectors.toList());

        Set<Member> membersForMeeting = createMeetingDTO.getMemberIdReplyMap()
                .keySet().stream()
                .map(memberStore::getMember)
                .collect(Collectors.toSet());

        Meeting meeting = MeetingMapper.map(createMeetingDTO, game, room, topicsForMeeting, membersForMeeting);
        meetingStore.createMeeting(meeting);
        return meeting.getId();
    }

    @Override
    public void deleteMeeting(String id) {
        meetingStore.deleteMeeting(id);
    }
}
