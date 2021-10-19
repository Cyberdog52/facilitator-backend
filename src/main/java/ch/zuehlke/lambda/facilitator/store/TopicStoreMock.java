package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Topic;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class TopicStoreMock implements TopicStore {

    static final List<Topic> topics = new ArrayList<>(List.of(
            new Topic("1", "Tamara News", "Neueste Infos über Zühlke", MemberStoreMock.members.get(0)),
            new Topic("2", "Team Retro", "Höchste Zeit wieder für eine Retro", MemberStoreMock.members.get(1)),
            new Topic("3", "Gspürmschmi-Spieli", "Tanzt eure Namen", MemberStoreMock.members.get(2))
    ));


    @Override
    public Collection<Topic> getTopics() {
        return topics;
    }

    @Override
    public Topic getTopic(String id) throws NotFoundException {
        return topics.stream()
                .filter(topic -> topic.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find topic with id " + id));
    }

    @Override
    public void updateTopic(Topic topic) throws NotFoundException {
        Topic topicToReplace = this.getTopic(topic.getId());
        Collections.replaceAll(topics, topicToReplace, topic);
    }

    @Override
    public void createTopic(Topic topic) {
        topics.add(topic);
    }

    @Override
    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
