package stats.services;

import java.util.ArrayList;

import stats.domain.Player;

public interface PlayerService {
	ArrayList<Player> listAllPlayers();
	
	Player getPlayerById(Integer id);
	
	Player savePlayer(Player player);
	
	void deletePlayer(Integer id);
	
	ArrayList<String> listAllPlayerNames();

}
