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
		return gameRepository.findAllBySeason(season_number);
	}

	@Override
	public Game findGameBySeasonAndGame(Integer season_number, Integer game_number) {
		return gameRepository.findOneBySeasonAndGame(season_number, game_number);
	}

}