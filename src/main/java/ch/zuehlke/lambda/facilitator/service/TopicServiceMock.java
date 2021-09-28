package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateTopicDTO;
import ch.zuehlke.lambda.facilitator.dto.TopicDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicServiceMock implements TopicService {

    private final MemberService memberService;

    @Autowired
    public TopicServiceMock(MemberService memberService) {
        this.memberService = memberService;
    }

    private static final List<TopicDTO> topics = new ArrayList<>(List.of(
            new TopicDTO("1", "Tamara News", "Neueste Infos über Zühlke", "1"),
            new TopicDTO("2", "Team Retro", "Höchste Zeit wieder für eine Retro", "2"),
            new TopicDTO("3", "Gspürmschmi-Spieli", "Tanzt eure Namen", "3")
    ));

    @Override
    public Collection<TopicDTO> getTopics() {
        return topics;
    }

    @Override
    public TopicDTO getTopic(String id) throws NotFoundException {
        return topics.stream()
                .filter(topicDTO -> topicDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find topic with id " + id));
    }

    @Override
    public void updateTopic(TopicDTO topicDTO) throws NotFoundException {
        TopicDTO topicToReplace = this.getTopic(topicDTO.getId());
        Collections.replaceAll(topics, topicToReplace, topicDTO);
    }

    @Override
    public void createTopic(CreateTopicDTO createTopicDTO) {
        topics.add(new TopicDTO(UUID.randomUUID().toString(), createTopicDTO.getTitle(), createTopicDTO.getDescription(), createTopicDTO.getAssigneeId()));
    }

    @Override
    public void deleteTopic(String id) {
        topics.removeIf(topicDTO -> topicDTO.getId().equals(id));
    }
}
