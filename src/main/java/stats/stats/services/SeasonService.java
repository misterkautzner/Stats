package stats.services;

import java.util.ArrayList;

import stats.domain.Season;

public interface SeasonService {
	
	ArrayList<Season> listAllSeasons();
	
	Season getSeasonByNumber(Integer season_number);
	
	//Season getSeasonByNumber(Integer season_number);
	
	Season saveSeason(Season season);
	
	void deleteSeasonByNumber(Integer season_number);
}
