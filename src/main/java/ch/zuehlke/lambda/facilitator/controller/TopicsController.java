package ch.zuehlke.lambda.facilitator.controller;

import ch.zuehlke.lambda.facilitator.dto.CreateTopicDTO;
import ch.zuehlke.lambda.facilitator.dto.TopicDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/topics")
public class TopicsController {

    private final TopicService topicService;

    @Autowired
    public TopicsController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public Collection<TopicDTO> getTopics() {
        return this.topicService.getTopics();
    }

    @GetMapping("/{id}")
    public TopicDTO getTopic(@PathVariable String id) {
        return this.topicService.getTopic(id);
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody TopicDTO topicDTO) {
        if (!topicDTO.getId().equals(id)) {
            throw new BadRequestException("The id " + id + " does not match the updated topicDTO");
        }

        this.topicService.updateTopic(topicDTO);
    }

    @PostMapping
    public void createTopic(@RequestBody CreateTopicDTO createTopicDTO) {
        this.topicService.createTopic(createTopicDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable String id) {
        this.topicService.deleteTopic(id);
    }

}