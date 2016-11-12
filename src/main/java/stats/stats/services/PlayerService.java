package stats.services;

import java.util.List;

import stats.domain.Player;

public interface PlayerService {
	List<Player> listAllPlayers();
	
	Player getPlayerById(Integer id);
	
	Player savePlayer(Player player);
	
	void deletePlayer(Integer id);
	
	List<String> listAllPlayerNames();

}
