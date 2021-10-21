package ch.zuehlke.lambda.facilitator.repository;

import ch.zuehlke.lambda.facilitator.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {
}
