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
import java.util.Map;
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
        Meeting meeting = mapMeeting(meetingDTO, meetingDTO.getGameId(), meetingDTO.getRoomId(), meetingDTO.getTopicIds(), meetingDTO.getMemberIdReplyMap());
        meetingStore.updateMeeting(meeting);
    }

    @Override
    public String createMeeting(CreateMeetingDTO createMeetingDTO) {
        Meeting meeting = mapMeeting(createMeetingDTO, createMeetingDTO.getGameId(), createMeetingDTO.getRoomId(), createMeetingDTO.getTopicIds(), createMeetingDTO.getMemberIdReplyMap());
        meetingStore.createMeeting(meeting);
        return meeting.getId();
    }

    private Meeting mapMeeting(Object meetingDto, String gameId, String roomId, Collection<String> topicIds, Map<String, String> topicIdReplyMap) {
        Game game = gameId == null ? null : gameStore.getGame(gameId);
        Room room = roomId == null ? null : roomStore.getRoom(roomId);

        List<Topic> topicsForMeeting = topicIds == null ? null :
                topicIds.stream()
                        .map(topicStore::getTopic)
                        .collect(Collectors.toList());

        Set<Member> membersForMeeting = topicIdReplyMap == null ? null :
                topicIdReplyMap.keySet().stream()
                        .map(memberStore::getMember)
                        .collect(Collectors.toSet());

        if (meetingDto instanceof MeetingDTO) {
            return MeetingMapper.map((MeetingDTO) meetingDto, game, room, topicsForMeeting, membersForMeeting);
        } else if (meetingDto instanceof CreateMeetingDTO) {
            return MeetingMapper.map((CreateMeetingDTO) meetingDto, game, room, topicsForMeeting, membersForMeeting);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMeeting(String id) {
        meetingStore.deleteMeeting(id);
    }
}
