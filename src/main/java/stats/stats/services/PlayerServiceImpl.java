package stats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Player;
import stats.repositories.PlayerRepository;



@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

    
//    public void setProductRepository(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }

    @Override
    public Iterable<Player> listAllPlayers() {
        return playerRepository.findAll();
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
}

