package stats.services;

import java.util.ArrayList;

import stats.domain.SeasonStat;
import stats.domain.Stat;

public interface StatService {
	
	ArrayList<Stat> listStatsByGame(Integer game_id);
	
	Stat getStatById(Integer stat_id);
	
	Stat saveStat(Stat stat);
	
	void deleteStatById(Integer stat_id);
	
	ArrayList<Stat> listPlayerStats(Integer player_id);
	
	ArrayList<SeasonStat> listPlayerSeasonStat(Integer player_id);
	
	SeasonStat getCareerStat(Integer player_id);

}
