package guru.springframework.services;

import guru.springframework.domain.Game;
import guru.springframework.domain.GameId;

public interface GameService {
	Iterable<Game> listAllGames();
	
	Iterable<Game> listBySeason(Integer season_number); // Implement
	
	//Game getGameById(GameId gameId);
	
	//Game getGameById(Integer season_number, Integer game_number);
	
	Game saveGame(Game game);
	
	void deleteGame(Game game);
}
