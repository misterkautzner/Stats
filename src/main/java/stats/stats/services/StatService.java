package stats.services;

import stats.domain.Stat;

public interface StatService {
	
	Iterable<Stat> listStatsByGame(Integer game_id);
	
	Stat getStatById(Integer stat_id);
	
	Stat saveStat(Stat stat);
	
	void deleteStatById(Integer stat_id);

}
