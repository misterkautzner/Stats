package stats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stats.domain.Stat;
import stats.repositories.StatRepository;

@Service
public class StatServiceImpl implements StatService {
	
	@Autowired
	StatRepository statRepository;

	@Override
	public ArrayList<Stat> listStatsByGame(Integer game_id) {
		return statRepository.findAllByGameId(game_id);
	}

	@Override
	public Stat getStatById(Integer stat_id) {
		return statRepository.findOne(stat_id);
	}

	@Override
	public Stat saveStat(Stat stat) {
		return statRepository.save(stat);
	}

	@Override
	public void deleteStatById(Integer stat_id) {
		statRepository.delete(stat_id);
	}

	@Override
	public ArrayList<Stat> listPlayerStats(Integer player_id) {
		return statRepository.findAllByPlayerId(player_id);
	}

}
