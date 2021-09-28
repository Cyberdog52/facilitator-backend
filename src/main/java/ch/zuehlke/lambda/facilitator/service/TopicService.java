package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateTopicDTO;
import ch.zuehlke.lambda.facilitator.dto.TopicDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface TopicService {

    Collection<TopicDTO> getTopics();

    TopicDTO getTopic(String id) throws NotFoundException;

    void updateTopic(TopicDTO topicDTO) throws NotFoundException;

    void createTopic(CreateTopicDTO createTopicDTO);

    void deleteTopic(String id);
}
