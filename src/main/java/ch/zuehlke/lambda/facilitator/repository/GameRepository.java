package ch.zuehlke.lambda.facilitator.repository;

import ch.zuehlke.lambda.facilitator.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, String> {
}
