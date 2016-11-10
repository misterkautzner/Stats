package stats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Game;
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

	@Override
	public ArrayList<Game> listBySeason(Integer season_number) {
		return gameRepository.findAllSeason(season_number);
	}

	@Override
	public Game findGameBySeasonAndGame(Integer season_number, Integer game_number) {
		return gameRepository.findOneBySeasonAndGame(season_number, game_number);
	}



//	@Override
//	public Season getSeasonByNumber(Integer season_number) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override Season getSeasonById(Integer season_id) {
//		return seasonRepository.
//	}


}