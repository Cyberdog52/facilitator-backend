package ch.zuehlke.lambda.facilitator.repository;

import ch.zuehlke.lambda.facilitator.domain.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, String> {
}
