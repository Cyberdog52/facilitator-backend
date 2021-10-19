package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.domain.Member;
import ch.zuehlke.lambda.facilitator.domain.Topic;
import ch.zuehlke.lambda.facilitator.dto.CreateTopicDTO;
import ch.zuehlke.lambda.facilitator.dto.TopicDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.mapper.TopicMapper;
import ch.zuehlke.lambda.facilitator.store.MemberStore;
import ch.zuehlke.lambda.facilitator.store.TopicStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicStore topicStore;
    private final MemberStore memberStore;

    @Autowired
    public TopicServiceImpl(TopicStore topicStore, MemberStore memberStore) {
        this.topicStore = topicStore;
        this.memberStore = memberStore;
    }

    @Override
    public Collection<TopicDTO> getTopics() {
        Collection<Topic> topics = topicStore.getTopics();
        return TopicMapper.map(topics);
    }

    @Override
    public TopicDTO getTopic(String id) throws NotFoundException {
        Topic topic = topicStore.getTopic(id);
        return TopicMapper.map(topic);
    }

    @Override
    public void updateTopic(TopicDTO topicDTO) throws NotFoundException {
        Member member = topicDTO.getAssigneeId() == null ? null : memberStore.getMember(topicDTO.getAssigneeId());
        Topic topic = TopicMapper.map(topicDTO, member);
        topicStore.updateTopic(topic);
    }

    @Override
    public String createTopic(CreateTopicDTO createTopicDTO) {
        Member member = createTopicDTO.getAssigneeId() == null ? null : memberStore.getMember(createTopicDTO.getAssigneeId());
        Topic topic = TopicMapper.map(createTopicDTO, member);
        topicStore.createTopic(topic);
        return topic.getId();
    }

    @Override
    public void deleteTopic(String id) {
        topicStore.deleteTopic(id);
    }
}
