package stats.services;

import stats.domain.Game;
import stats.domain.Season;

public interface GameService {
	Iterable<Game> listAllGames();
	
//	Iterable<Game> listBySeason(Integer season_number); // Implement
	
	Game getGameById(Integer gameId);
	
	Game saveGame(Game game);
	
	void deleteGameById(Integer gameId);
	
	Season getSeasonByNumber(Integer season_number);
}
