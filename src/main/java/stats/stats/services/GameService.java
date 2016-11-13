package stats.services;

import java.util.ArrayList;

import stats.domain.Game;

public interface GameService {
	
	Iterable<Game> listAllGames();
	
	ArrayList<Game> listBySeason(Integer season_number); // Implement
	
	Game getGameById(Integer game_id);
	
	Game saveGame(Game game);
	
//	Game findGameBySeasonAndGame(Integer season_number, Integer game_number);
	
	void deleteGameById(Integer game_id);
	
	
//	Season getSeasonByNumber(Integer season_number);
}
