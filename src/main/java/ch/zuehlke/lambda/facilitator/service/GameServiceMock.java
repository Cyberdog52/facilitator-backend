package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateGameDTO;
import ch.zuehlke.lambda.facilitator.dto.GameDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceMock implements GameService {

    private static final List<GameDTO> games = new ArrayList<>(List.of(
            new GameDTO("1", "Skribbl", "https://skribbl.io/"),
            new GameDTO("2", "Codenames", "https://horsepaste.com/")
    ));

    @Override
    public Collection<GameDTO> getGames() {
        return games;
    }

    @Override
    public GameDTO getGame(String id) throws NotFoundException {
        return games.stream()
                .filter(gameDTO -> gameDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find game with id " + id));
    }

    @Override
    public void updateGame(GameDTO gameDTO) throws NotFoundException {
        GameDTO gameToReplace = this.getGame(gameDTO.getId());
        Collections.replaceAll(games, gameToReplace, gameDTO);
    }

    @Override
    public void createGame(CreateGameDTO createGameDTO) {
        games.add(new GameDTO(UUID.randomUUID().toString(), createGameDTO.getTitle(), createGameDTO.getUri()));
    }

    @Override
    public void deleteGame(String id) {
        games.removeIf(gameDTO -> gameDTO.getId().equals(id));
    }
}
