package ch.zuehlke.lambda.facilitator.mapper;

import ch.zuehlke.lambda.facilitator.domain.Game;
import ch.zuehlke.lambda.facilitator.dto.CreateGameDTO;
import ch.zuehlke.lambda.facilitator.dto.GameDTO;
import ch.zuehlke.lambda.facilitator.exception.BadRequestException;
import ch.zuehlke.lambda.facilitator.util.StringUtil;
import io.micrometer.core.instrument.util.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameMapper {

    public static Collection<GameDTO> map(Collection<Game> games) {
        return games.stream()
                .map(GameMapper::map)
                .collect(Collectors.toList());
    }

    public static GameDTO map(Game game) {
        return GameDTO.builder()
                .id(game.getId())
                .title(game.getTitle())
                .description(game.getDescription())
                .uri(StringUtil.toStringOrDefault(game.getUri(), ""))
                .build();
    }

    public static Game map(GameDTO gameDTO) {
        Game.GameBuilder gameBuilder = Game.builder().id(gameDTO.getId())
                .title(gameDTO.getTitle())
                .description(gameDTO.getDescription());

        if (StringUtils.isNotEmpty(gameDTO.getUri())) {
            try {
                gameBuilder.uri(new URI(gameDTO.getUri())).build();
            } catch (URISyntaxException e) {
                throw new BadRequestException("Could not create URI for string " + gameDTO.getUri());
            }
        }

        return gameBuilder.build();
    }

    public static Game map(CreateGameDTO createGameDTO) {
        GameDTO gameDTO = GameDTO.builder().id(UUID.randomUUID().toString())
                .title(createGameDTO.getTitle())
                .description(createGameDTO.getDescription())
                .uri(createGameDTO.getUri())
                .build();

        return GameMapper.map(gameDTO);
    }
}
