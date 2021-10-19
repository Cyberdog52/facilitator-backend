package ch.zuehlke.lambda.facilitator.mapper;

import ch.zuehlke.lambda.facilitator.domain.*;
import ch.zuehlke.lambda.facilitator.dto.CreateMeetingDTO;
import ch.zuehlke.lambda.facilitator.dto.MeetingDTO;

import java.util.*;
import java.util.stream.Collectors;

public class MeetingMapper {
    public static Collection<MeetingDTO> map(Collection<Meeting> meetings) {
        return meetings.stream()
                .map(MeetingMapper::map)
                .collect(Collectors.toList());
    }

    public static MeetingDTO map(Meeting meeting) {
        Map<String, String> memberIdReplyStringMap = new HashMap<>();
        if (meeting.getMemberReplyMap() != null) {
            for (Map.Entry<Member, Reply> entry : meeting.getMemberReplyMap().entrySet()) {
                memberIdReplyStringMap.put(entry.getKey().getId(), entry.getValue().name());
            }
        }

        return MeetingDTO.builder()
                .id(meeting.getId())
                .timeInMillis(meeting.getDate() == null ? 0L : meeting.getDate().getTime())
                .gameId(meeting.getGame() == null ? null : meeting.getGame().getId())
                .roomId(meeting.getRoom() == null ? null : meeting.getRoom().getId())
                .topicIds(meeting.getTopics() == null ? null : meeting.getTopics().stream().map(Topic::getId).collect(Collectors.toList()))
                .memberIdReplyMap(memberIdReplyStringMap)
                .build();
    }

    public static Meeting map(MeetingDTO meetingDTO, Game game, Room room, List<Topic> topicsForMeeting, Set<Member> membersForMeeting) {
        return Meeting.builder()
                .id(meetingDTO.getId())
                .date(new Date(meetingDTO.getTimeInMillis()))
                .game(game)
                .room(room)
                .topics(topicsForMeeting)
                .memberReplyMap(MeetingMapper.map(meetingDTO.getMemberIdReplyMap(), membersForMeeting))
                .build();
    }

    private static Map<Member, Reply> map(Map<String, String> memberIdReplyDtoMap, Set<Member> membersForMeeting) {
        if (memberIdReplyDtoMap == null) {
            return null;
        }

        Map<Member, Reply> memberReplyMap = new HashMap<>();
        for (Member member : membersForMeeting) {
            Reply reply = Reply.fromString(memberIdReplyDtoMap.get(member.getId()));
            memberReplyMap.put(member, reply);
        }

        return memberReplyMap;
    }

    public static Meeting map(CreateMeetingDTO createMeetingDTO, Game game, Room room, List<Topic> topicsForMeeting, Set<Member> membersForMeeting) {
        MeetingDTO meetingDTO = MeetingDTO.builder()
                .id(UUID.randomUUID().toString())
                .timeInMillis(createMeetingDTO.getTimeInMillis())
                .gameId(game == null ? null : game.getId())
                .roomId(room == null ? null : room.getId())
                .topicIds(createMeetingDTO.getTopicIds())
                .memberIdReplyMap(createMeetingDTO.getMemberIdReplyMap())
                .build();

        return MeetingMapper.map(meetingDTO, game, room, topicsForMeeting, membersForMeeting);
    }
}
