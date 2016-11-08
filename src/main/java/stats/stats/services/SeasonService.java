package stats.services;

import stats.domain.Season;

public interface SeasonService {
	
	Iterable<Season> listAllSeasons();
	
	Season getSeasonById(Integer season_id);
	
	//Season getSeasonByNumber(Integer season_number);
	
	Season saveSeason(Season season);
	
	void deleteSeasonById(Integer season_id);
}
