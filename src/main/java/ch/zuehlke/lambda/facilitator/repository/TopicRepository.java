package ch.zuehlke.lambda.facilitator.repository;

import ch.zuehlke.lambda.facilitator.domain.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
}
