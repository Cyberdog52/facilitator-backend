package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Game;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;

import java.util.Collection;

public interface GameStore {

    Collection<Game> getGames();

    Game getGame(String id) throws NotFoundException;

    void updateGame(Game game) throws NotFoundException;

    void createGame(Game game);

    void deleteGame(String id);
}
