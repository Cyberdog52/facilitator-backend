package ch.zuehlke.lambda.facilitator.controller;

import ch.zuehlke.lambda.facilitator.dto.CreateGameDTO;
import ch.zuehlke.lambda.facilitator.dto.GameDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/games")
public class GamesController {

    private final GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public Collection<GameDTO> getGames() {
        return this.gameService.getGames();
    }

    @GetMapping("/{id}")
    public GameDTO getGame(@PathVariable String id) {
        return this.gameService.getGame(id);
    }

    @PutMapping
    public void updateGame(@RequestBody GameDTO gameDTO) {
        this.gameService.updateGame(gameDTO);
    }

    @PostMapping
    public String createGame(@RequestBody CreateGameDTO createGameDTO) {
        return this.gameService.createGame(createGameDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        this.gameService.deleteGame(id);
    }

}
