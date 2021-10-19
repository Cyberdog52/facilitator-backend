package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Topic;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;

import java.util.Collection;

public interface TopicStore {

    Collection<Topic> getTopics();

    Topic getTopic(String id) throws NotFoundException;

    void updateTopic(Topic topic) throws NotFoundException;

    void createTopic(Topic topic);

    void deleteTopic(String id);
}
