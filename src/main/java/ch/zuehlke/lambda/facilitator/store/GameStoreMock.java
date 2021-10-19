package ch.zuehlke.lambda.facilitator.store;

import ch.zuehlke.lambda.facilitator.domain.Game;
import ch.zuehlke.lambda.facilitator.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class GameStoreMock implements GameStore {

    static List<Game> games;

    static {
        try {
            games = new ArrayList<>(List.of(
                    new Game("1", "Skribbl", "Montagsmaler", new URI("https://skribbl.io/")),
                    new Game("2", "Codenames", "Ein Teamspiel bei dem einer Begriffe mit einem Wort zusammenfassen muss und die anderen die Begriffe erraten.", new URI("https://horsepaste.com/")),
                    new Game("3", "Rucksackspiel", "Jeder packt einen Gegenstand ein und muss zuvor alle bereits eingepackten Gegenstände der anderen Spieler aufzählen.", null)
            ));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Game> getGames() {
        return games;
    }

    @Override
    public Game getGame(String id) throws NotFoundException {
        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find game with id " + id));
    }

    @Override
    public void updateGame(Game game) throws NotFoundException {
        Game gameToReplace = this.getGame(game.getId());
        Collections.replaceAll(games, gameToReplace, game);
    }

    @Override
    public void createGame(Game game) {
        games.add(game);
    }

    @Override
    public void deleteGame(String id) {
        games.removeIf(game -> game.getId().equals(id));
    }
}
