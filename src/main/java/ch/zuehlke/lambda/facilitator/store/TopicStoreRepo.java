package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Topic;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.repository.TopicRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile(value = "!dev")
public class TopicStoreRepo implements TopicStore {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicStoreRepo(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Collection<Topic> getTopics() {
        return IteratorUtils.toList(topicRepository.findAll().iterator());
    }

    @Override
    public Topic getTopic(String id) throws NotFoundException {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isEmpty()) {
            throw new NotFoundException("Could not find topic with id " + id);
        }

        return topicOptional.get();
    }

    @Override
    public void updateTopic(Topic topic) throws NotFoundException {
        topicRepository.save(topic);
    }

    @Override
    public void createTopic(Topic newTopic) {
        topicRepository.save(newTopic);
    }

    @Override
    public void deleteTopic(String id) {
        try {
            topicRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not delete topic with id " + id);
        }
    }
}
