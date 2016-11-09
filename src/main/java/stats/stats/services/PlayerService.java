package stats.services;

import stats.domain.Player;

public interface PlayerService {
	Iterable<Player> listAllPlayers();
	
	Player getPlayerById(Integer id);
	
	Player savePlayer(Player player);
	
	void deletePlayer(Integer id);

}
