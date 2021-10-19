package ch.zuehlke.lambda.facilitator.mapper;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.domain.Topic;
import ch.zuehlke.lambda.facilitator.dto.CreateTopicDTO;
import ch.zuehlke.lambda.facilitator.dto.TopicDTO;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class TopicMapper {

    public static Collection<TopicDTO> map(Collection<Topic> topics) {
        return topics.stream()
                .map(TopicMapper::map)
                .collect(Collectors.toList());
    }

    public static TopicDTO map(Topic topic) {
        return TopicDTO.builder().id(topic.getId())
                .title(topic.getTitle())
                .description(topic.getDescription())
                .assigneeId(topic.getAssignee() == null ? null : topic.getAssignee().getId())
                .build();
    }

    public static Topic map(TopicDTO topicDTO, Member member) {
        return Topic.builder().id(topicDTO.getId())
                .title(topicDTO.getTitle())
                .description(topicDTO.getDescription())
                .assignee(member)
                .build();
    }

    public static Topic map(CreateTopicDTO createTopicDTO, Member member) {
        TopicDTO topicDTO = TopicDTO.builder().id(UUID.randomUUID().toString())
                .title(createTopicDTO.getTitle())
                .description(createTopicDTO.getDescription())
                .assigneeId(createTopicDTO.getAssigneeId())
                .build();

        return TopicMapper.map(topicDTO, member);
    }
}
