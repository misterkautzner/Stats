package stats.services;

import stats.domain.Game;

public interface GameService {
	Iterable<Game> listAllGames();
	
	Iterable<Game> listBySeason(Integer season_number); // Implement
	
	Game getGameById(Integer gameId);
	
	//Game getGameById(Integer season_number, Integer game_number);
	
	Game saveGame(Game game);
	
	void deleteGameById(Integer gameId);
}
