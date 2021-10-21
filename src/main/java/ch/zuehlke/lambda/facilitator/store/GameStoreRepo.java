package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Game;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.repository.GameRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile(value = "!dev")
public class GameStoreRepo implements GameStore {

    private final GameRepository gameRepository;

    @Autowired
    public GameStoreRepo(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Collection<Game> getGames() {
        return IteratorUtils.toList(gameRepository.findAll().iterator());
    }

    @Override
    public void createGame(Game newGame) {
        gameRepository.save(newGame);
    }

    @Override
    public void updateGame(Game game) throws NotFoundException {
        gameRepository.save(game);
    }

    @Override
    public Game getGame(String id) throws NotFoundException {
        Optional<Game> gameOptional = gameRepository.findById(id);
        if (gameOptional.isEmpty()) {
            throw new NotFoundException("Could not find game with id " + id);
        }

        return gameOptional.get();
    }

    @Override
    public void deleteGame(String id) {
        try {
            gameRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not delete game with id " + id);
        }
    }
}
