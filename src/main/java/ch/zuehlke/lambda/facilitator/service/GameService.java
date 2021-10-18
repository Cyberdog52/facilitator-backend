package ch.zuehlke.lambda.facilitator.service;

import ch.zuehlke.lambda.facilitator.dto.CreateGameDTO;
import ch.zuehlke.lambda.facilitator.dto.GameDTO;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface GameService {

    Collection<GameDTO> getGames();

    GameDTO getGame(String id) throws NotFoundException;

    void updateGame(GameDTO gameDTO) throws NotFoundException;

    String createGame(CreateGameDTO createGameDTO);

    void deleteGame(String id);
}
