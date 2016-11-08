package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Game;
import stats.domain.Season;
import stats.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired	
	private GameRepository gameRepository;
	

//	public void setGameRepository(GameRepository gameRepository) {
//		this.gameRepository = gameRepository;
//	}
	
	@Override
	public Iterable<Game> listAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Game getGameById(Integer game_id) {
		return gameRepository.findOne(game_id);
	}

	@Override
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public void deleteGameById(Integer game_id) {
		gameRepository.delete(game_id);
	}

//	@Override
//	public Iterable<Game> listBySeason(Integer season_number) {  
//		Iterable<Game> allGames = gameRepository.findAll();
//		ArrayList<Game> seasonGames = new ArrayList<Game>();
//		for(Game game : allGames) {
//			if(game.getSeason_number() == season_number) {
//				seasonGames.add(game);
//			}
//		}
//		return seasonGames;
//	}

	@Override
	public Season getSeasonByNumber(Integer season_number) {
		// TODO Auto-generated method stub
		return null;
	}


}