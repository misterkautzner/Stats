package guru.springframework.services;

import guru.springframework.domain.Season;

public interface SeasonService {
	Iterable<Season> listAllSeasons();
	
	Season getSeasonByNumber(Integer season_number);
	
	Season saveSeason(Season season);
	
	void deleteSeasonByNumber(Integer season_number);
}
