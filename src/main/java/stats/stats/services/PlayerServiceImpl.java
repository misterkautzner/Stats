package stats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Player;
import stats.repositories.PlayerRepository;



@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

    @Override
    public ArrayList<Player> listAllPlayers() {
        return (ArrayList<Player>) playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Integer id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

	@Override
	public void deletePlayer(Integer id) {
		playerRepository.delete(playerRepository.findOne(id));
	}

	@Override
	public ArrayList<String> listAllPlayerNames() {
		return playerRepository.findAllPlayerNames();
	}
}

