package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.domain.Game;
import ch.zuehlke.lambda.facilitator.dto.CreateGameDTO;
import ch.zuehlke.lambda.facilitator.dto.GameDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import ch.zuehlke.lambda.facilitator.mapper.GameMapper;
import ch.zuehlke.lambda.facilitator.store.GameStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GameServiceImpl implements GameService {

    private final GameStore gameStore;

    @Autowired
    public GameServiceImpl(GameStore gameStore) {
        this.gameStore = gameStore;
    }

    @Override
    public Collection<GameDTO> getGames() {
        Collection<Game> games = gameStore.getGames();
        return GameMapper.map(games);
    }

    @Override
    public GameDTO getGame(String id) throws NotFoundException {
        Game game = gameStore.getGame(id);
        return GameMapper.map(game);
    }

    @Override
    public void updateGame(GameDTO gameDTO) throws NotFoundException {
        Game game = GameMapper.map(gameDTO);
        gameStore.updateGame(game);
    }

    @Override
    public String createGame(CreateGameDTO createGameDTO) {
        Game newGame = GameMapper.map(createGameDTO);
        gameStore.createGame(newGame);
        return newGame.getId();
    }

    @Override
    public void deleteGame(String id) {
        gameStore.deleteGame(id);
    }
}
